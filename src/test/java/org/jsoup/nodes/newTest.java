package org.jsoup.nodes;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class newTest {


    @Test
    public void hasAssociatedControls() {
        //"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"
        String html = "<form id=1><button id=1><fieldset id=2 /><input id=3><keygen id=4><object id=5><output id=6>" +
                "<select id=7><option></select><textarea id=8><p id=9>";
        Document doc = Jsoup.parse(html);

        FormElement form = (FormElement) doc.select("form").first();
        assertEquals(8, form.elements().size());
    }


    /**
     *  Element coverage tests
     */
    /////// Elements with attribute starting
    /// Adding... getElementsByAttributeStarting
    @Test void elementWithAttributesStarting(){
        Document doc = Jsoup.parse("<div><span class=' mellow yellow '>Hello <b>Yellow</b></span></div>");
        List<Element> els = doc.getElementsByAttributeStarting("cl");
        Element span = els.get(0);
        assertTrue(span.hasClass("mellow"));
    }

    /////// Elements with attribute by value
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

    //TODO: get by index
    @Test public void handlesEscapedScript2() {
//        Document doc = Jsoup.parse("<script><!-- one <script>-lah</script> --></script>");
        Document doc = Jsoup.parse("<script><!-- one <script>");
        assertEquals("<!-- one <script>Blah</script> -->", doc.select("script").first().data());
    }
}

