package org.jsoup.nodes;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FSMTest {


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

        div.addClass("class1");
        assertEquals(div.toString(),"<" + tag + " class=\"class1\"></" + tag + ">");

        div.addClass("class2");
        assertEquals(div.toString(),"<" + tag + " class=\"class1 class2\"></" + tag + ">");

        div.addClass("class1");
        assertEquals(div.toString(),"<" + tag + " class=\"class1 class2\"></" + tag + ">");

        div.removeAttr("class");
        assertEquals(div.toString(),"<" + tag + "></" + tag + ">");
    }

}
