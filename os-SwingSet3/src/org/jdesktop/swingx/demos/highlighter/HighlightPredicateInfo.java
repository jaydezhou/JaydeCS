/*
 * $Id: HighlightPredicateInfo.java 1164 2009-11-03 04:22:00Z kschaefe $
 *
 * Copyright 2009 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.jdesktop.swingx.demos.highlighter;

import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.util.Contract;

/**
 * A wrapper object that associates a description with a highlight predicate.
 * 
 * @author Karl George Schaefer
 */
public final class HighlightPredicateInfo {
    private final String description;
    private final HighlightPredicate predicate;
    
    public HighlightPredicateInfo(String description, HighlightPredicate predicate) {
        this.description = Contract.asNotNull(description,
                "description cannot be null");
        this.predicate = predicate;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the highlighter
     */
    public HighlightPredicate getPredicate() {
        return predicate;
    }
}
