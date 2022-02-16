package org.jsoup.nodes;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.junit.jupiter.api.Test;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class newTest {


    /**
     *  Element coverage tests
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



    //Covers self closing start tag condition under tokenzier state.
    @Test public void testIsValidWithMisshapedTagEnds() {
        String nok1 = "<p><script></script/Not<b>OK</b></p>";
        Safelist sl = Safelist.basic();
        assertFalse(Jsoup.isValid(nok1, sl));
    }


    /***
     *  Tokenizer state coverage test
     */
    @Test public void testScriptDataState() {
        Document doc = Jsoup.parse("<script><!-- one <script>\u0000</script> --></script>");
        assertEquals("", doc.select("script").first().text());
    }

    @Test public void testScriptDataState2() {
        Document doc = Jsoup.parse("<script><!-- one <script></script> --></script>");
        assertEquals("", doc.select("script").first().text());
    }

    @Test public void handlesEscapedScript() {
        Document doc = Jsoup.parse("<script><!-- one <script>-lah</script> --></script>");
        assertEquals("<!-- one <script>-lah</script> -->", doc.select("script").first().data());
    }

    @Test public void handlesEOFScript() {
        Document doc = Jsoup.parse("<script><!-- one <script>");
        assertEquals("<!-- one <script>", doc.select("script").first().data());
    }

    @Test public void handlesDoubleEscapedScript() {
        Document doc = Jsoup.parse("<script><!-- one <script>--lah</script> --></script>");
        assertEquals("<!-- one <script>--lah</script> -->", doc.select("script").first().data());
    }

    @Test public void handlesScriptDataDoubleEscapedLessthanSign() {
        Document doc = Jsoup.parse("<script><!-- one <script>-<lah</script> --></script>");
        assertEquals("<!-- one <script>-<lah</script> -->", doc.select("script").first().data());
    }

    @Test public void handleScriptDataDoubleEscaped() {
        Document doc = Jsoup.parse("<script><!-- one <script>-\u0000lah</script> --></script>");
        assertEquals("", doc.select("script").first().text());
    }
    @Test public void handleScriptDataEscapedAndEOF() {
        Document doc = Jsoup.parse("<script><!-- one <script>-");
        assertEquals("", doc.select("script").first().text());
    }

    @Test public void handlesDoubleEscapedDashDash() {
        Document doc = Jsoup.parse("<script><!-- one <script>---lah</script> --></script>");
        assertEquals("<!-- one <script>---lah</script> -->", doc.select("script").first().data());
    }

    @Test public void handlesDoubleEscapedDashDash2() {
        Document doc = Jsoup.parse("<script><!-- one <script>---lah</script> --></script>");
        assertEquals("<!-- one <script>---lah</script> -->", doc.select("script").first().data());
    }

    @Test public void handlesDoubleEscapedDashDash3() {
        Document doc = Jsoup.parse("<script><!-- one <script>--<lah</script> --></script>");
        assertEquals("<!-- one <script>--<lah</script> -->", doc.select("script").first().data());
    }

    @Test public void handlesDoubleEscapedDashDash4() {
        Document doc = Jsoup.parse("<script><!-- one <script>-->lah</script> --></script>");
        assertEquals("<!-- one <script>-->lah", doc.select("script").first().data());
    }

    @Test public void handlesDoubleEscapedDashDash5() {
        Document doc = Jsoup.parse("<script><!-- one <script>---\u0000lah</script> --></script>");
        assertEquals("", doc.select("script").first().text());
    }

    @Test public void handlesDoubleEscapedDashDash6() {
        Document doc = Jsoup.parse("<script><!-- one <script>--");
        assertEquals("<!-- one <script>--", doc.select("script").first().data());
    }

    @Test public void handlesDoubleEscapedDashDash7() {
        Document doc = Jsoup.parse("<script><!-- one <script>--Blah</script> --></script>");
        assertEquals("<!-- one <script>--Blah</script> -->", doc.select("script").first().data());
    }
}

