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

package org.javacs.debug.proto;

/** Arguments for 'stackTrace' request. */
public class StackTraceArguments {
    /** Retrieve the stacktrace for this thread. */
    public long threadId;
    /** The index of the first frame to return; if omitted frames start at 0. */
    public int startFrame;
    /** The maximum number of frames to return. If levels is not specified or 0, all frames are returned. */
    public Integer levels;
    /** Specifies details on how to format the stack frames. */
    public StackFrameFormat format;
}
