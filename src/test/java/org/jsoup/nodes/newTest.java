package org.jsoup.nodes;

import org.jsoup.parser.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        System.out.println(a.toString());
        Attribute b = Attribute.createFromEncoded("/w","hello");
        System.out.println(b.toString());
        Assertions.assertEquals(a.toString(),b.toString());
        Document out = new Document("www.baidu.com");
        boolean iscoll = a.shouldCollapseAttribute(out.outputSettings());
        Assertions.assertEquals(a.toString(),b.toString());
    }
    @Test
    public void testCollapseAttribute() {
        String k = "w";
        String v = "hello";
        Attribute a = new Attribute(k,v);
        // map and cloneable
        System.out.println(a.toString());
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
        System.out.println(a.toString());
        String t = "fs";
        Document out = new Document("www.baidu.com");
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
        System.out.println(hashAtt);
    }
    @Test
    public void testClone() {
        String k = "class";
        String v = "hello";
        Attribute a = new Attribute(k,v);
        Attribute same = new Attribute(k,v);
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
    System.out.println(d.html());
    System.out.println(newD.html());
    }

    @Test
    public void testDocumentComplicatedNor() {
        Document d = new Document("www.baidu.com");
        Document newD = d.normalise();
        System.out.println(d.html());
        System.out.println(newD.html());
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
        String tagName1 = p1.toString();
        String tagName2 = p2.toString();
        System.out.println(tagName1 +"  "+tagName2);
        Boolean result = p1.equals(p2);
        assertTrue(p1.equals(p2));
    }



}
