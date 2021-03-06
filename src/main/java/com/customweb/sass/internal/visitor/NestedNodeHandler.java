/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.customweb.sass.internal.visitor;

import java.util.Collection;

import com.customweb.sass.internal.ScssContext;
import com.customweb.sass.internal.tree.NestPropertiesNode;
import com.customweb.sass.internal.tree.Node;

/**
 * Handle nested properties nodes (e.g. "font: { family: serif; }" to
 * "font-family: serif;").
 * 
 * Sample SASS code (from www.sass-lang.com):
 * 
 * <pre>
 * li {
 *   font: {
 *     family: serif;
 *     weight: bold;
 *     size: 1.2em;
 *   }
 * }
 * </pre>
 * 
 * Note that this does not apply to nested blocks, which are handled by
 * {@link BlockNodeHandler}.
 */
public class NestedNodeHandler {

    public static Collection<Node> traverse(ScssContext context,
            NestPropertiesNode node) {
        node.replaceVariables(context);
        return node.unNesting();
    }
}