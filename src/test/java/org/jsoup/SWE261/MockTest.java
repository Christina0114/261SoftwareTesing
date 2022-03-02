package org.jsoup.SWE261;

import org.jsoup.nodes.*;
import org.jsoup.parser.Tag;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


public class MockTest {

    private Element ele;
    private Tag tag;
    private Attributes attributes;

    @Spy
    Tag tagP = Tag.valueOf("p");
    @Spy
    Attributes atts = new Attributes().add("class", "note");

    @Before
    public void setup() {
        tag = mock(Tag.class);
        attributes = mock(Attributes.class);
        ele = new Element(tag, "", atts);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkAttsMockObject() {
        Assertions.assertTrue(attributes instanceof Attributes);
    }

    @Test
    public void checkEleObject() {
        Assertions.assertTrue(ele instanceof Node);
        Assertions.assertTrue(ele instanceof Element);
    }

    @Test
    public void checkTagObject() {
        Assertions.assertTrue(tag instanceof Tag);
        Assertions.assertTrue(tag instanceof Cloneable);
    }

    @Test
    public void getElementTest() {
        when(tag.getName()).thenReturn("p");
        System.out.println(ele.tagName());
        verify(tag, times(1)).getName();
        System.out.println(ele.isBlock());
        verify(tag, times(1)).isBlock();
        System.out.println(ele.cssSelector());
        verify(tag, times(2)).getName();
    }

    @Test
    public void normalTagTest() {
        System.out.println(ele.normalName());
        verify(tag, times(1)).normalName();
    }

    @Test
    public void textTest() {
        System.out.println(ele.text());
        verify(tag, times(1)).isBlock();
    }
    @Test
    public  void testSpy(){
        Element e = new Element(tagP,"",atts);
        System.out.println(e.tag());
    }

}
