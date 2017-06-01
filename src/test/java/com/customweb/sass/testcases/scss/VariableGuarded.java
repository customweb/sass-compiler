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

public class VariableGuarded extends AbstractTestBase {
    String scss = "/scss/var-guarded.scss";
    String css = "/css/var-guarded.css";

    @Test
    public void testParser() throws CSSException, IOException {
        Parser parser = new Parser();
        SCSSDocumentHandler handler = new SCSSDocumentHandlerImpl();
        parser.setDocumentHandler(handler);
        parser.parseStyleSheet(getClass().getResource(scss).getPath());
        ScssStylesheet root = handler.getStyleSheet();
        Assert.assertEquals(4, root.getChildren().size());
    }

    @Test
    public void testCompiler() throws Exception {
        testCompiler(scss, css);
        Assert.assertEquals("Original CSS and parsed CSS doesn't match",
                comparisonCss, parsedScss);
    }
}
