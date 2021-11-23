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

/** Optional properties of a variable that can be used to determine how to render the variable in the UI. */
public class VariablePresentationHint {
    /**
     * The kind of variable. Before introducing additional values, try to use the listed values. Values: 'property':
     * public * Indicates that the object is a property. 'method': Indicates that the object is a method. 'class':
     * Indicates that public * the object is a class. 'data': Indicates that the object is data. 'event': Indicates that
     * the object is an event. public * 'baseClass': Indicates that the object is a base class. 'innerClass': Indicates
     * that the object is an inner public * class. 'interface': Indicates that the object is an interface.
     * 'mostDerivedClass': Indicates that the object is public * the most derived class. 'virtual': Indicates that the
     * object is virtual, that means it is a synthetic object introduced by the adapter for rendering purposes, e.g. an
     * index range for large arrays. 'dataBreakpoint': Indicates that a data breakpoint is registered for the object.
     * etc.
     */
    public String kind;
    /**
     * Set of attributes represented as an array of strings. Before introducing additional values, try to use the listed
     * values. Values: 'static': Indicates that the object is static. 'constant': Indicates that the object is a
     * constant. 'readOnly': Indicates that the object is read only. 'rawString': Indicates that the object is a raw
     * string. 'hasObjectId': Indicates that the object can have an Object ID created for it. 'canHaveObjectId':
     * Indicates that the object has an Object ID associated with it. 'hasSideEffects': Indicates that the evaluation
     * had side effects. etc.
     */
    public String[] attributes;
    /**
     * Visibility of variable. Before introducing additional values, try to use the listed values. Values: 'public',
     * 'private', 'protected', 'internal', 'final', etc.
     */
    public String visibility;
}
