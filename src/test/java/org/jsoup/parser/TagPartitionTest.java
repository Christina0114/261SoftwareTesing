package org.jsoup.parser;

import org.jsoup.MultiLocaleExtension.MultiLocaleTest;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Here we do the partition test for semantics of the tags.
 */
public class TagPartitionTest {
    /**
     * Test for the root group
     */
    @Test public void rootSemantics() {
        Tag html = Tag.valueOf("html");
        assertTrue(html.isBlock());
        assertTrue(html.formatAsBlock());
        assertFalse(html.isSelfClosing());
        assertFalse(html.isInline());
        assertFalse(html.isFormListed());
        assertFalse(html.isFormSubmittable());
    }

    /**
     *test for the meta doc group
     */
    @Test public void docMetaSemantics() {
        Tag meta = Tag.valueOf("meta");
        assertTrue(meta.isBlock());
        assertTrue(meta.formatAsBlock());
        assertTrue(meta.isSelfClosing());
        assertFalse(meta.isInline());
        assertFalse(meta.isFormListed());
        assertFalse(meta.isFormSubmittable());
    }

    @Test public void styleSemantics() {
        Tag style = Tag.valueOf("style");
        assertTrue(style.isBlock());
        assertFalse(style.formatAsBlock());
        assertFalse(style.isSelfClosing());
        assertFalse(style.isEmpty());
        assertFalse(style.isSelfClosing());
        assertFalse(style.isInline());
        assertFalse(style.isFormListed());
        assertFalse(style.isFormSubmittable());
    }

    /**
    for content tags
     */
    @Test public void headerSemantics() {
        Tag header = Tag.valueOf("header");
        assertTrue(header.isBlock());
        assertTrue(header.formatAsBlock());
        assertFalse(header.isSelfClosing());
        assertFalse(header.isEmpty());
        assertFalse(header.isSelfClosing());
        assertFalse(header.isInline());
        assertFalse(header.isFormListed());
        assertFalse(header.isFormSubmittable());
    }

    /**
     for content tags
     */
    @Test public void hgroupSemantics() {
        Tag hgroup = Tag.valueOf("hgroup");
        assertTrue(hgroup.isBlock());
        assertTrue(hgroup.formatAsBlock());
        assertFalse(hgroup.isSelfClosing());
        assertFalse(hgroup.isEmpty());
        assertFalse(hgroup.isSelfClosing());
        assertFalse(hgroup.isInline());
        assertFalse(hgroup.isFormListed());
        assertFalse(hgroup.isFormSubmittable());
    }

    /**
     for text tags:
     */
    @Test public void divSemantics() {
        Tag div = Tag.valueOf("div");
        assertTrue(div.isBlock());
        assertTrue(div.formatAsBlock());
        assertFalse(div.isSelfClosing());
        assertFalse(div.isEmpty());
        assertFalse(div.isSelfClosing());
        assertFalse(div.isInline());
        assertFalse(div.isFormListed());
        assertFalse(div.isFormSubmittable());
    }
    /**
     for text tags: main
     */
    @Test public void mainSemantics() {
        Tag style = Tag.valueOf("main");
        assertTrue(style.isBlock());
        assertTrue(style.formatAsBlock());
        assertFalse(style.isSelfClosing());
        assertFalse(style.isEmpty());
        assertFalse(style.isSelfClosing());
        assertFalse(style.isInline());
        assertFalse(style.isFormListed());
        assertFalse(style.isFormSubmittable());
    }

    /**
     for Inline tags: main
     */
    @Test public void spanSemantics() {
        Tag span = Tag.valueOf("span");
        assertFalse(span.isBlock());
        assertFalse(span.formatAsBlock());
        assertFalse(span.isSelfClosing());
        assertFalse(span.isEmpty());
        assertFalse(span.isSelfClosing());
        assertTrue(span.isInline());
        assertFalse(span.isFormListed());
        assertFalse(span.isFormSubmittable());
    }
    /**
     for Inline tags: samp
     */
    @Test public void sampSemantics() {
        Tag span = Tag.valueOf("samp");
        assertFalse(span.isBlock());
        assertFalse(span.formatAsBlock());
        assertFalse(span.isSelfClosing());
        assertFalse(span.isEmpty());
        assertFalse(span.isSelfClosing());
        assertTrue(span.isInline());
        assertFalse(span.isFormListed());
        assertFalse(span.isFormSubmittable());
    }
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
    /*
         Multimedia Tags
        */
    @Test public void audioSemantics() {
        Tag t = Tag.valueOf("audio");
        assertFalse(t.isInline());
        assertFalse(t.isSelfClosing());
        assertTrue(t.isBlock());
        assertTrue(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test public void videoSemantics() {
        Tag t = Tag.valueOf("video");
        assertFalse(t.isInline());
        assertFalse(t.isSelfClosing());
        assertTrue(t.isBlock());
        assertTrue(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test public void imgSemantics() {
        Tag t = Tag.valueOf("img");
        assertTrue(t.isInline());
        assertTrue(t.isSelfClosing());
        assertFalse(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test public void mapSemantics() {
        Tag t = Tag.valueOf("map");
        assertTrue(t.isInline());
        assertFalse(t.isSelfClosing());
        assertFalse(t.isBlock());
        assertFalse(t.isEmpty());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @MultiLocaleTest
    public void checkNormalTagName() {
        String name1 = "IMG";
        Tag p = Tag.valueOf(name1);
        String name2 = p.normalName();
        assertEquals(name1.toLowerCase(Locale.ROOT), name2);
    }

    /*
    Embedded Contents Tags
     */
    @Test
    public void iframeSemantics() {
        Tag t = Tag.valueOf("iframe");
        assertTrue(t.isInline());
        assertFalse(t.isSelfClosing());
        assertFalse(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test
    public void embedSemantics() {
        Tag t = Tag.valueOf("embed");
        assertTrue(t.isInline());
        assertTrue(t.isSelfClosing());
        assertFalse(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test
    public void objectSemantics() {
        Tag t = Tag.valueOf("object");
        assertTrue(t.isInline());
        assertFalse(t.isSelfClosing());
        assertFalse(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertTrue(t.isFormListed());
        assertTrue(t.isFormSubmittable());
    }

    /*
    Script Contents Tags
    */
    @Test
    public void canvasSemantics() {
        Tag t = Tag.valueOf("canvas");
        assertFalse(t.isInline());
        assertFalse(t.isSelfClosing());
        assertTrue(t.isBlock());
        assertTrue(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test
    public void scriptSemantics() {
        Tag t = Tag.valueOf("script");
        assertFalse(t.isInline());
        assertFalse(t.isSelfClosing());
        assertTrue(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    /*
    Edit Tags
    */
    @Test
    public void delSemantics() {
        Tag t = Tag.valueOf("del");
        assertFalse(t.isInline());
        assertFalse(t.isSelfClosing());
        assertTrue(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test
    public void insSemantics() {
        Tag t = Tag.valueOf("ins");
        assertFalse(t.isInline());
        assertFalse(t.isSelfClosing());
        assertTrue(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    /*
    Deprecated Tags
     */
    @Test
    public void acronymSemantics() {
        Tag t = Tag.valueOf("acronym");
        assertTrue(t.isInline());
        assertFalse(t.isSelfClosing());
        assertFalse(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test
    public void keygenSemantics() {
        Tag t = Tag.valueOf("keygen");
        assertTrue(t.isInline());
        assertTrue(t.isSelfClosing());
        assertFalse(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertTrue(t.isFormListed());
        assertTrue(t.isFormSubmittable());
    }

    @Test
    public void fontSemantics() {
        Tag t = Tag.valueOf("font");
        assertTrue(t.isInline());
        assertFalse(t.isSelfClosing());
        assertFalse(t.isBlock());
        assertFalse(t.formatAsBlock());
        assertFalse(t.isFormListed());
        assertFalse(t.isFormSubmittable());
    }

    @Test
    public void menuItemIsKnown() {
        assertTrue(Tag.isKnownTag("menuitem"));
    }

    /* Not able to recognize the following tags:
         blink, isindex, content, element, image,
         multicol, nextid, noembed, spacer, shadow, xmp

    But all other deprecated HTML4 tags are handled inside Tag class.
    For example, below tests fail:

    @Test public void elementIsKnown() {
        assertTrue(Tag.isKnownTag("element"));
    }

    @Test public void blinkIsKnown() {
        assertTrue(Tag.isKnownTag("blink"));
    }

    @Test public void contentIsKnown() {
        assertTrue(Tag.isKnownTag("content"));
    }
    */


}
