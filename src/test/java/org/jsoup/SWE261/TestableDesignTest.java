package org.jsoup.SWE261;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestableDesignTest {
    @Test
    public void testHtml() throws IOException {
        String input =
                "<html>"
                        +   "<head>"
                        +     "<meta http-equiv=\"content-type\" content=\"text/html; charset=Shift_JIS\" />"
                        +   "</head>"
                        +   "<body>"
                        +     "before&nbsp;after"
                        +   "</body>"
                        + "</html>";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.US_ASCII));
        Document doc = Jsoup.parse(is, null, "http://example.com");
        Element root = doc.htmlElNew();
        String expectedString =  "<html>\n" +
                " <head>\n" +
                "  <meta http-equiv=\"content-type\" content=\"text/html; charset=Shift_JIS\">\n" +
                " </head>\n" +
                " <body>\n" +
                "  before&nbsp;after\n" +
                " </body>\n" +
                "</html>";
        Assertions.assertEquals(root.toString(),expectedString);
    }
    @Test
    public void testEmptyHtml() throws IOException {
        String input = "";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.US_ASCII));
        Document doc = Jsoup.parse(is, null, "http://example.com");
        Element root = doc.htmlElNew();
        String expectedString =  "<html>\n" +
                " <head></head>\n" +
                " <body></body>\n" +
                "</html>";
        Assertions.assertEquals(root.toString(),expectedString);
    }

}