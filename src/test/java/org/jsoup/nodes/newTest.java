package org.jsoup.nodes;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.jsoup.parser.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class newTest {
    /**
     * test for Attribute
     */
    @Test
    public void testCreateFromEncoded() {
        String k = "w";
        String v = "hello";
        Attribute a = new Attribute(k,v);
        // map and cloneable
        Attribute b = Attribute.createFromEncoded("/w","hello");
        Assertions.assertEquals(a.toString(),b.toString());
        Assertions.assertEquals(a.toString(),b.toString());
    }
    @Test
    public void testCollapseAttribute() {
        String k = "w";
        String v = "hello";
        Attribute a = new Attribute(k,v);
        // map and cloneable
        Document out = new Document("www.baidu.com");
        boolean iscoll = a.shouldCollapseAttribute(out.outputSettings());
        Assertions.assertFalse(iscoll);
    }
    @Test
    public void testCollable() {
        String k = "w";
        String v = "hello";
        Attribute a = new Attribute(k,v);
        Attribute sameAtt = new Attribute(k,v);
        Attribute diffAtt = new Attribute("neww",v);
        // map and cloneable
        String t = "fs";
        Assertions.assertFalse(a.equals(t));
        Assertions.assertFalse(a.equals(null));
        Assertions.assertTrue(a.equals(sameAtt));
        Assertions.assertFalse(a.equals(diffAtt));
    }
    @Test
    public void testHashCode() {
        String k = "w";
        String v = "hello";
        Attribute a = new Attribute(k,v);
        int hashAtt = a.hashCode();
        assertEquals(99166011, hashAtt);
    }

    @Test
    public void testClone() {
        String k = "class";
        String v = "hello";
        Attribute a = new Attribute(k,v);
        Attribute cloneAtt = a.clone();
        Assertions.assertTrue(a.equals(cloneAtt));
    }

    /**
     * Test for document
     */
    @Test
    public void testDocumentEasyNor() {
        Document d = new Document("www.example.com");
        Document newD = d.normalise();
    }

    @Test
    public void testDocumentComplicatedNor() {
        Document d = new Document("www.baidu.com");
        Document newD = d.normalise();
    }

    /**
     * Test for tag
     */
    @Test
    public void testTagHash() {
        Tag p1 = Tag.valueOf("P");
        int tagHashValue = p1.hashCode();
        Assertions.assertEquals(tagHashValue,-1421590287);
    }
    @Test public void testTagEqual() {
        Tag p1 = Tag.valueOf("p");
        Tag p2 = p1;
        assertTrue(p1.equals(p2));
    }


    /**
     *  Test for Element
     */
    @Test void elementByAttributesStarting(){
        Document doc = Jsoup.parse("<div><span class=' mellow yellow '>Hello <b>Yellow</b></span></div>");
        List<Element> els = doc.getElementsByAttributeStarting("cl");
        Element span = els.get(0);
        assertTrue(span.hasClass("mellow"));
    }

    @Test void elementsByAttributeValue(){
        Document doc = Jsoup.parse(
                "<span class='class1'>Hello</span>" +
                "<span class='myclass2'>test</span>" +
                "<span style='padding:1px'></span>");

        Element span = doc.getElementsByAttributeValueContaining("class","myclass2").last();
        assertTrue(span.hasClass("myclass2"));

        span = doc.getElementsByAttributeValueMatching("class","class1").get(0);
        assertTrue(span.hasClass("class1"));

        span = doc.getElementsByAttributeValueEnding("style","px").get(0);
        assertTrue(span.hasAttr("style"));

        span = doc.getElementsByAttributeStarting("class").get(0);;
        assertTrue(span.hasClass("class1"));

        span = doc.getElementsByAttributeValueNot("class","class1").last();
        assertTrue(span.hasAttr("style"));
    }

    @Test void elementsByText(){
        Document doc = Jsoup.parse(
                "<span class='class1'>Hello</span>" +
                        "<span class='myclass2'>World</span>" +
                        "<span style='padding:1px'></span>");

        Element span = doc.getElementsContainingText("Hel").last();
        assertTrue(span.hasClass("class1"));
        assertFalse(span.hasAttr("style"));

        span = doc.getElementsMatchingText("World").last();
        assertTrue(span.hasClass("myclass2"));
    }



    /***
     *  Test for TokenizerState
     */
    @Test public void testIsValidWithMisshapedTagEnds() {
        String nok1 = "<p><script></script/Not<b>OK</b></p>";
        Safelist sl = Safelist.basic();
        assertFalse(Jsoup.isValid(nok1, sl));
    }

    @Test public void testScriptDataState() {
        Document doc = Jsoup.parse("<script><!-- one <script>\u0000</script> --></script>");
        assertEquals("", doc.select("script").first().text());

        doc = Jsoup.parse("<script><!-- one <script></script> --></script>");
        assertEquals("", doc.select("script").first().text());
    }


    /***
     *  TokenizerState: Tokenizer states handling script element and escape
     */
    @Test public void handlesEscapedScript() {
        // Escape inside script
        Document doc = Jsoup.parse("<script><!-- one <script>-lah</script> --></script>");
        assertEquals("<!-- one <script>-lah</script> -->", doc.select("script").first().data());

        // EOF
        doc = Jsoup.parse("<script><!-- one <script>");
        assertEquals("<!-- one <script>", doc.select("script").first().data());

        // Double-escaped
        doc = Jsoup.parse("<script><!-- one <script>--lah</script> --></script>");
        assertEquals("<!-- one <script>--lah</script> -->", doc.select("script").first().data());

        // "<" after escape
        doc = Jsoup.parse("<script><!-- one <script>-<lah</script> --></script>");
        assertEquals("<!-- one <script>-<lah</script> -->", doc.select("script").first().data());

        // nullChar after escape
        doc = Jsoup.parse("<script><!-- one <script>-\u0000lah</script> --></script>");
        assertEquals("", doc.select("script").first().text());

        //Escaped and EOF
        doc = Jsoup.parse("<script><!-- one <script>-");
        assertEquals("", doc.select("script").first().text());
    }

    @Test public void handlesDoubleEscapedScript() {
        // another -
        Document doc = Jsoup.parse("<script><!-- one <script>---lah</script> --></script>");
        assertEquals("<!-- one <script>---lah</script> -->", doc.select("script").first().data());

        // < after escape
        doc = Jsoup.parse("<script><!-- one <script>--<lah</script> --></script>");
        assertEquals("<!-- one <script>--<lah</script> -->", doc.select("script").first().data());

        // > after escape
        doc = Jsoup.parse("<script><!-- one <script>-->lah</script> --></script>");
        assertEquals("<!-- one <script>-->lah", doc.select("script").first().data());

        // nullChar after escape
        doc = Jsoup.parse("<script><!-- one <script>---\u0000lah</script> --></script>");
        assertEquals("", doc.select("script").first().text());

        // EOF after escape
        doc = Jsoup.parse("<script><!-- one <script>--");
        assertEquals("<!-- one <script>--", doc.select("script").first().data());

        // default escape
        doc = Jsoup.parse("<script><!-- one <script>--Blah</script> --></script>");
        assertEquals("<!-- one <script>--Blah</script> -->", doc.select("script").first().data());
    }
}