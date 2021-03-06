package org.jsoup.SWE261;
import org.jsoup.nodes.*;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiniteStateMachineTest {
    /**
     * SWE261P - Finite Model Testing
     *
     * The following tests cover the finite state machine model reported in Project part 2.
     * The testing focuses on JSoup's ability to add and remove classes to and from a given Element
     * All the nodes and transitions are covered.
     *
     *
     * @author Joseph Lee, Wenjun Chen, Ying Che
     */
    @ParameterizedTest
    @CsvSource({"<div></div>, div", "<p></p>, p", "<h></h>, h", "<title></title>, title", "<footer></footer>, footer"})
    void testAddClass(String html, String tag){
        Document doc = Jsoup.parse(html);
        Element div = doc.select(tag).first();

        div.addClass("class1");
        assertEquals(div.toString(),"<" + tag + " class=\"class1\"></" + tag + ">");

        div.addClass("class1"); // self-edge
        assertEquals(div.toString(),"<" + tag + " class=\"class1\"></" + tag + ">");

        div.addClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class1 class2\"></" + tag + ">");

        div.addClass("class1"); // self-edge
        assertEquals(div.toString(),"<" + tag + " class=\"class1 class2\"></" + tag + ">");

        div.addClass("class2"); // self-edge
        assertEquals(div.toString(),"<" + tag + " class=\"class1 class2\"></" + tag + ">");

        div.removeAttr("class");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");
    }


    @ParameterizedTest
    @CsvSource({"<div></div>, div", "<p></p>, p", "<h></h>, h", "<title></title>, title", "<footer></footer>, footer"})
    void testRemoveClass(String html, String tag){
        Document doc = Jsoup.parse(html);
        Element div = doc.select(tag).first();

        /*
        remove the original class name
         */
        div.addClass("class1");
        div.removeClass("class1");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");


        /*
        remove class 1 and class 2 from an empty
         */
        div.removeClass("class1");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");

        div.removeClass("class2");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");


        /*
        remove non-exist class name
         */
        div.addClass("class1");
        div.removeClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class1\"></" + tag + ">");

        /*
        remove existed class name to the original state
         */
        div.addClass("class1");
        div.addClass("class2");
        div.removeClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class1\"></" + tag + ">");
    }


    @ParameterizedTest
    @CsvSource({"<div></div>, div", "<p></p>, p", "<h></h>, h", "<title></title>, title", "<footer></footer>, footer"})
    void testResetClass(String html, String tag){
        Document doc = Jsoup.parse(html);
        Element div = doc.select(tag).first();

        // reset the no class to empty
        div.removeAttr("class");    // self-edge
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");

        // reset the class1 to empty
        div.addClass("class1");
        assertEquals(div.toString(),"<" + tag + " class=\"class1\"></" + tag + ">");
        div.removeAttr("class");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");

        // reset the class2 to empty
        div.addClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class2\"></" + tag + ">");
        div.removeAttr("class");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");

        // reset the class1 and class2 to empty
        div.addClass("class1");
        div.addClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class1 class2\"></" + tag + ">");
        div.removeAttr("class");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");
    }

    @ParameterizedTest
    @CsvSource({"<div></div>, div", "<p></p>, p", "<h></h>, h", "<title></title>, title", "<footer></footer>, footer"})
    void testAddClass2(String html, String tag){
        Document doc = Jsoup.parse(html);
        Element div = doc.select(tag).first();

        div.addClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class2\"></" + tag + ">");

        /*
         * test for self edge
         * */
        div.addClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class2\"></" + tag + ">");

        div.addClass("class1");
        assertEquals(div.toString(),"<" + tag + " class=\"class2 class1\"></" + tag + ">");

        /*
        * test for self edge
        * */
        div.addClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class2 class1\"></" + tag + ">");
    }


    @ParameterizedTest
    @CsvSource({"<div></div>, div", "<p></p>, p", "<h></h>, h", "<title></title>, title", "<footer></footer>, footer"})
    void testRemoveClass2(String html, String tag){
        Document doc = Jsoup.parse(html);
        Element div = doc.select(tag).first();

        // start with 2 original classes
        div.addClass("class1");
        div.addClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class1 class2\"></" + tag + ">");

        div.removeClass("class1");
        assertEquals(div.toString(),"<" + tag + " class=\"class2\"></" + tag + ">");

        div.removeClass("class1");  // self-edge
        assertEquals(div.toString(),"<" + tag + " class=\"class2\"></" + tag + ">");

        div.removeClass("class2");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");

        div.removeClass("class1");  // self-edge
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");

        div.removeClass("class2");  // self-edge
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");
    }


}
