/************************************************************************************
 * This file is part of Java Language Server (https://github.com/itsaky/java-language-server)
 *
 * Copyright (C) 2021 Akash Yadav
 *
 * Java Language Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Java Language Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Java Language Server.  If not, see <https://www.gnu.org/licenses/>.
 *
**************************************************************************************/

package org.javacs.completion;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreeScanner;
import com.sun.source.util.Trees;
import java.io.IOException;

public class PruneMethodBodies extends TreeScanner<StringBuilder, Long> {
    
    private final JavacTask task;
    private final StringBuilder buf = new StringBuilder();
    private CompilationUnitTree root;

    public PruneMethodBodies(JavacTask task) {
        this.task = task;
    }

    @Override
    public StringBuilder visitCompilationUnit(CompilationUnitTree t, Long find) {
        root = t;
        try {
            var contents = t.getSourceFile().getCharContent(true);
            buf.setLength(0);
            buf.append(contents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        super.visitCompilationUnit(t, find);
        return buf;
    }

    @Override
    public StringBuilder visitMethod(MethodTree t, Long find) {
        var pos = Trees.instance(task).getSourcePositions();
        if (t.getBody() == null) return buf;
        var start = pos.getStartPosition(root, t.getBody());
        var end = pos.getEndPosition(root, t.getBody());
        if (!(start <= find && find < end)) {
            for (var i = (int) start + 1; i < end - 1; i++) {
                if (!Character.isWhitespace(buf.charAt(i))) {
                    buf.setCharAt(i, ' ');
                }
            }
            return buf;
        }
        super.visitMethod(t, find);
        return buf;
    }

    @Override
    public StringBuilder reduce(StringBuilder a, StringBuilder b) {
        return buf;
    }
}
