package org.jsoup.parser;

import org.jsoup.MultiLocaleExtension.MultiLocaleTest;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class TagTestAdd {
    /**
     *  for Table content group
     */

    @Test public void colgroupSemantics() {
        Tag colgroup = Tag.valueOf("colgroup");
        assertFalse(colgroup.isInline());
        assertFalse(colgroup.isSelfClosing());
        assertTrue(colgroup.isBlock());
    }

    @Test public void theadSemantics() {
        Tag thead = Tag.valueOf("thead");
        assertFalse(thead.isInline());
        assertFalse(thead.isSelfClosing());
        assertTrue(thead.isBlock());
    }

    @Test public void tdSemantics() {
        Tag td = Tag.valueOf("td");
        assertFalse(td.isInline());
        assertFalse(td.isSelfClosing());
        assertTrue(td.isBlock());
    }

    /**
     * for table group
     */
    @Test public void legendSemantics() {
        Tag legend = Tag.valueOf("legend");
        assertTrue(legend.isInline());
        assertFalse(legend.isSelfClosing());
        assertFalse(legend.isBlock());
    }

    @Test public void selectSemantics() {
        Tag select = Tag.valueOf("select");
        assertTrue(select.isInline());
        assertFalse(select.isSelfClosing());
        assertFalse(select.isBlock());
    }

    /**
     * for interactive element group
     */
    @Test public void summarySemantics() {
        Tag summary = Tag.valueOf("summary");
        assertTrue(summary.isInline());
        assertFalse(summary.isSelfClosing());
        assertFalse(summary.isBlock());
    }

    @Test public void detailsSemantics() {
        Tag details = Tag.valueOf("details");
        assertFalse(details.isInline());
        assertFalse(details.isSelfClosing());
        assertTrue(details.isBlock());
    }

    /**
     * for web group
     */
    @Test public void templateSemantics() {
        Tag template = Tag.valueOf("template");
        assertFalse(template.isInline());
        assertFalse(template.isSelfClosing());
        assertTrue(template.isBlock());
    }

    // 8 test cases added
}
