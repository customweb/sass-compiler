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

package com.customweb.sass.testcases.scss;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.w3c.css.sac.CSSException;

import com.customweb.sass.AbstractTestBase;
import com.customweb.sass.internal.ScssStylesheet;
import com.customweb.sass.internal.handler.SCSSDocumentHandler;
import com.customweb.sass.internal.handler.SCSSDocumentHandlerImpl;
import com.customweb.sass.internal.parser.Parser;
import com.customweb.sass.internal.tree.BlockNode;
import com.customweb.sass.internal.tree.NestPropertiesNode;
import com.customweb.sass.internal.tree.RuleNode;

public class NestedProperties extends AbstractTestBase {
    String scss = "/scss/nested-properties.scss";
    String css = "/css/nested-properties.css";

    @Test
    public void testParser() throws CSSException, IOException {
        Parser parser = new Parser();
        SCSSDocumentHandler handler = new SCSSDocumentHandlerImpl();
        parser.setDocumentHandler(handler);
        parser.parseStyleSheet(getClass().getResource(scss).getPath());
        ScssStylesheet root = handler.getStyleSheet();
        Assert.assertEquals(1, root.getChildren().size());

        BlockNode blockNode = (BlockNode) root.getChildren().get(0);
        Assert.assertEquals(1, blockNode.getChildren().size());

        NestPropertiesNode nestPropertiesNode = (NestPropertiesNode) blockNode
                .getChildren().get(0);
        Assert.assertEquals("font", nestPropertiesNode.getName().toString());
        RuleNode nestedProperty0 = (RuleNode) nestPropertiesNode.getChildren()
                .get(0);
        RuleNode nestedProperty1 = (RuleNode) nestPropertiesNode.getChildren()
                .get(1);
        RuleNode nestedProperty2 = (RuleNode) nestPropertiesNode.getChildren()
                .get(2);
        Assert.assertEquals("family", nestedProperty0.getVariable().toString());
        Assert.assertEquals("weight", nestedProperty1.getVariable().toString());
        Assert.assertEquals("size", nestedProperty2.getVariable().toString());
    }

    @Test
    public void testCompiler() throws Exception {
        testCompiler(scss, css);
    }
}
