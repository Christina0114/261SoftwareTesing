package org.jsoup.parser;

import org.jsoup.MultiLocaleExtension.MultiLocaleTest;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
