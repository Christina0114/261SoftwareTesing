# SWE261P Project: Part 1

Wenjun Chen

Ying Che

Joseph Young Lee

## Overview

In this part of the project, we chose an open-source project developed in Java, [Jsoup](https://jsoup.org/), studied its use and included test protocols, and applied custom tests to provide additional verification of the system functionalities. The JUnit testing framework was used to drive the tests.

## JSoup Introduction

[Jsoup](https://jsoup.org/) is an open-source HTML parser project developed using Java. The latest version currently available is 1.14.3; which was released in Sept 2022.  There are 97 contributors building and maintaining this project, and it is also used by 99026 repositories from GitHub. This project consists of approximately 39k lines of code. For more information, please refer to the JSoup main website or the cookbook for instructions on how to use:

- [jsoup: Java HTML parser, built for HTML editing, cleaning, scraping, and XSS safety](https://jsoup.org/)

- [Cookbook: jsoup Java HTML parser](https://jsoup.org/cookbook/).

### Purpose

JSoup provides a very convenient API for fetching URLs and parsing the HTML contents for extracting and manipulating data. The following list highlights the popular uses of JSoup:

- Read and parse HTML contents from a given URL.

- Use DOM traversal or CSS selectors to find data.

- Manipulate the HTML elements, attributes, and text.

- Reformat given HTML and output it into a better-structured HTML.

- Clean user-submitted content against a safelist for security attacks like cross-site scripting.

## Building

### Requirements:

- Java 8 or newer versions

- Eclipse or IntelliJ

- JUNIT 5.8.2

- Other libraries in pom.xml

### Steps (Git):

1. Fork the original Jsoup repository and import it into a new repository.

2. Create and change the terminal directory to the folder where you wish to set up the project.  

3. Onto this folder, clone the following repository, which has been forked from the original JSoup repository for the purpose of this project.
   
   - Link: [GitHub - Christina0114/261SoftwareTesing at Christian](https://github.com/Christina0114/261SoftwareTesing/tree/Christian)
     
     ```shell
     git clone https://github.com/Christina0114/261SoftwareTesing.git
     ```

4. Then, in the terminal, set the directory onto the `261SoftwareTesing` root folder and use the following `Maven` command to build the project.  
   
   ```
   cd 261SoftwareTesing  
   mvn install
   ```

5. Using the above install command will run the unit and integration tests. We can also use the command line below to test the existing test files. This example is to test parsing attributes.
   
   ```
   mvn test -D test=org.jsoup.parser.AttributeParseTest
   ```

## Explore Existing Test Cases

Jsoup is composed of six main packages and each package has their own test cases:

| Package                                                                                 | Description                                                       |
| --------------------------------------------------------------------------------------- | ----------------------------------------------------------------- |
| [org.jsoup.helper](https://jsoup.org/apidocs/org/jsoup/helper/package-summary.html)     | Package containing classes supporting the core JSoup code.        |
| [org.jsoup.internal](https://jsoup.org/apidocs/org/jsoup/internal/package-summary.html) | Utility methods used by Jsoup.                                    |
| [org.jsoup.nodes](https://jsoup.org/apidocs/org/jsoup/nodes/package-summary.html)       | HTML document structure nodes.                                    |
| [org.jsoup.parser](https://jsoup.org/apidocs/org/jsoup/parser/package-summary.html)     | Contains the HTML parser, tag specifications, and HTML tokenizer. |
| [org.jsoup.safety](https://jsoup.org/apidocs/org/jsoup/safety/package-summary.html)     | Contains the JSoup HTML cleaner, and safelist definitions.        |
| [org.jsoup.select](https://jsoup.org/apidocs/org/jsoup/select/package-summary.html)     | Packages to support the CSS-style element selector.               |

The test cases provided in the project are used for checking the functionalities of the library according to the program specifications of each package. 

### How to run test files?

To run all the tests included in the package, we can also the Maven test command to run all JUnit tests in the project:

```shell
mvn test
```

### Existing Test Case: Functional Testing

```java
@Test public void defaultSemantics() {
        Tag foo = Tag.valueOf("FOO"); // not defined
        Tag foo2 = Tag.valueOf("FOO");

        assertEquals(foo, foo2);
        assertTrue(foo.isInline());
        assertTrue(foo.formatAsBlock());
    }

    @Test public void valueOfChecksNotNull() {
        assertThrows(IllegalArgumentException.class, () -> Tag.valueOf(null));
    }

    @Test public void valueOfChecksNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Tag.valueOf(" "));
    }

    @Test public void knownTags() {
        assertTrue(Tag.isKnownTag("div"));
        assertFalse(Tag.isKnownTag("explain"));
    }
@MultiLocaleTest
    public void canBeInsensitive(Locale locale) {
        Locale.setDefault(locale);

        Tag script1 = Tag.valueOf("script", ParseSettings.htmlDefault);
        Tag script2 = Tag.valueOf("SCRIPT", ParseSettings.htmlDefault);
        assertSame(script1, script2);
    }
```

The above testing example shows sample testing methods in the TagTest. The above test checks whether the Tag class is able to properly read the tags embedded in various types of elements. The above testing methods test whether if the semantics of the Tags are checked as expected, and also whether if the Tag class is able to handle incorrect inputs or if it can handle case sensitive cases. This protocol is used to confirm some of the functionalities in the Tag class.

### Existing Test Case: Integration Testing

The project also includes testing protocols that perform integration tests, which check for connection timeouts and interrupts. Integration testing is defined as a type of testing where software modules are integrated logically and tested as a group in order to evaluate the compliance of a system. Here, we use `src/test/java/org/jsoup/integration/ParseTest.java` as an example of the Integration Testing. In this test File, we can see the file structure here:

```shell
ParseTest
testSmhBizArticle
testNewsHomepage
testGoogleSearchIpod
testYahooJp
testBaidu
testBaiduVariant
testHtml5Charset
testBrokenHtml5CharsetWithASingleDoubleQuote
testNytArticle
testYahooArticle
testLowercaseUtf8Charset
testXwiki
testXwikiExpanded
testWikiExpandedFromString
testWikiFromString
testFileParseNoCharsetMethod
getFile
inputStreamFrom
getFileAsString
```

It tested different websites in English, Japanese and Chinese. See the `testNewsHomePage`. After we do the unit testing, which promises every component in the library works as expected. It starts with receiving the HTML file as an input, and then, It parses the main elements in the HTML object. It checks the title of the document. Besides, it uses the select method to extract the css element based on the CSS query. Then it tested the Node “href” in the element parsed from the CSS query.

## Partitioning and Testing

---

For this testing, we used two of the fundamental software techniques: Functional Testing and Partition Testing.

- Functional Testing

Functional testing is a type of black-box testing, which tests a slice of functionality of the whole system. Functional testing tests software's functionality without knowing the internal workings of the software. In turn, it could reduce developer bias in testing since the tester has not been involved in the software's development.

- Partition Testing

Partition testing is a technique that divides the input data of a software unit into partitions of data. In principle, test cases are designed to cover each partition at least once. This technique could reduce the total number of test cases. An advantage of this approach is reduction in the time required for testing software.

- What do we test?

Jsoup is used for parsing the web pages that are written in HTML; which is structured with varying formats containing various types of elements. Each element is labeled with an HTML Tag that describes the contents that the element stores. Since the inputs could vary and the handling for each input is different depending on the type, both functional testing and partitioning testing can be effective to verify the system behavior.

The Tag component was selected to perform the above testing. HTML web pages are structured with several elements that have  “HTML tags” labeled to describe the contents that the element stores. 

The testing was focused on testing functionalities of the Tag class for checking the semantics depending on different HTML Tags, and confirm whether it matches the expected values:

1. If the tags can be self-close

2. If the tags can be submitted in a form

3. If the tags can appear in form

4. if this tag should be formatted as a block 

5. if this tag should be formatted as inline

Testing this is important because JSoup needs to be able to correctly understand different types of tags included in the HTML elements, and for this reason, we are adding functional testing cases specifically for the Tag class under org.json.parser package to verify that this class can properly recognize all the tags, detect malformed tags and correct them if possible, and also categorize them into different types of element Tags properly.

### Partitioning Scheme

The tests on the Tag class were partitioned by separating the input spaces into the following categories as the boundaries depending on the use of the tag. Please refer to the below chart:

#### Input space partitioning

| **Tag Types**            | **Tag inputs**                                                                                                                                                                                                                                                                                                                                       |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Root                     | \<html>                                                                                                                                                                                                                                                                                                                                              |
| Doc metadata             | \<link>、\<meta>、\<style>、\<style>                                                                                                                                                                                                                                                                                                                    |
| Contents (semantic tags) | \<header>、\<nav>、\<section>、\<aside> 、\<footer> 、\<h1> ~ \<h6> 、\<article> 、\<address>、\<hgroup>                                                                                                                                                                                                                                                     |
| Texts                    | \<main>、\<div>、\<p>、\<pre>、\<ol>、 \<ul>、\<li>、\<dl> 、\<dt>、\<dd>、\<figure> 、\<figcaption>、\<blockquote> 、\<hr>                                                                                                                                                                                                                                       |
| Inline                   | \<span>、\<a>、\<strong>、\<em>、\<q>、\<br>、\<mark>、\<code>、\<abbr>、\<b>、\<bdi>、\<bdo>、\<sub>、\<sup>、\<time>、\<i>、\<u>、\<cite>、\<data>、\<kbd>、\<nobr>、\<s>、\<samp>、\<tt>、\<var>、\<wbr>、\<rp>、\<rt>、\<rtc>、\<ruby>                                                                                                                                        |
| Multimedia               | \<img\>、\<audio>、 \<video>、\<track>、\<map>、\<area>                                                                                                                                                                                                                                                                                                   |
| Embedded Contents        | \<iframe>、\<embed>、\<object> 、\<param>、\<picture>、\<source>                                                                                                                                                                                                                                                                                          |
| Script                   | \<canvas>、\<noscript>、\<script>                                                                                                                                                                                                                                                                                                                      |
| Edit                     | \<del>、\<ins>                                                                                                                                                                                                                                                                                                                                        |
| Table content            | \<table>、\<caption>、\<thead>、\<tbody>、\<tfoot>、\<tr>、\<col>,\<colgroup>、\<th>、\<td>                                                                                                                                                                                                                                                                  |
| Table                    | \<form> 、\<input>、\<textarea> 、\<label>、\<button>、\<datalist>、\<fieldset>、\<legend>、\<meter>、\<optgroup>、\<option>、\<output>、\<progress>、\<select>                                                                                                                                                                                                   |
| Interactive element      | \<details>、\<summary>、\<dialog>、\<menu>                                                                                                                                                                                                                                                                                                              |
| Web                      | \<slot>、\<template>                                                                                                                                                                                                                                                                                                                                  |
| Deprecated               | \<acronym>, \<applet>, \<basefont>, \<bgsound>, \<big>, \<blink>, \<center>, \<command>, \<content>, \<dir>, \<element>, \<font>, \<frame>, \<frameset>, \<image>, \<isindex>, \<keygen>, \<listing>, \<marquee>, \<menuitem>, \<multicol>, \<nextid>, \<nobr>, \<noembed>, \<noframes>, \<plaintext>, \<spacer>, \<strike>, \<shadow>,\<tt>, \<xmp> |

（Table 1. Table of HTML5 tags that have been categorized by its use）

### Testing

In the JSoup project, we choose TagTest as our partition feature.Different tags have different properties. Like we talked about \<img>, it doesn’t need a closing tag but \<html> needs a closing tag. In test cases, we try to figure out whether JSoup can process the correct tags as well as the deprecated tags. We use `assertTrue/assertFalse `function to test whether given tags `isInline`, `isSelfClosing`, `isBlock`, etc. In each input space, we choose some representative values to test.

For the boundary, here our input space is set, we don’t do the boundary testing here. In the existing test cases, empty values and null values are tested.

To drive the testing on the functionalities of the Tag class, using the above partitioning scheme, an additional JUnit testing JAVA file was programmed and added to the parser package in the test folder: `src/test/java/org/jsoup/parser/TagPartitionTest.java. `

You can run this by running the maven command, while at the root directory. This will run all of the other tests along with the newly added one.

```shell
mvn test -D test=org.jsoup.parser.TagPartitionTest
```

- Representative Values

| Tag Types                | Tag inputs                              |
| ------------------------ | --------------------------------------- |
| Root                     | \<html>                                 |
| Doc metadata             | \<meta>、\<style>                        |
| Contents (semantic tags) | \<header>、 \<hgroup>                    |
| Texts                    | \<main>、\<div>                          |
| Inline                   | \<span>、 \<samp>                        |
| Multimedia               | \<img>、 \<audio>、 \<video>              |
| Embedded Contents        | \<iframe>、\<embed>、\<object>            |
| Script                   | \<canvas>、\<script>                     |
| Edit                     | \<del>、\<ins>                           |
| Table content            | \<thead>、 \<colgroup>、\<td>             |
| Table                    | \<legend>、 \<select>                    |
| Interactive element      | \<details>、\<summary>、\<dialog>、\<menu> |
| Web                      | \<template>                             |
| Deprecated               | \<acronym>、 \<font>、 \<keygen>          |

### Findings

The testing protocol helped with verifying the semantics for different categories of the Tags get checked properly through the Tag class, and this protocol can be used in the future to check the functionalities of the Tag class. However, a minor issue was discovered where some of the deprecated tags, from older versions of HTML4, were not handled inside the Tag class.This includes the following: \<blink>, \<isindex>, \<content>, \<element>, \<image>, \<multicol>, \<nextid>, \<noembed>, \<spacer>, \<shadow>, \<xmp>. These are just a few of the deprecated tags, all of the other deprecated tags are properly recognized by the Tag class. This is not a big problem, but could run into issues where special handling for these deprecated tags are necessary.

## Reference

[Functional testing - Wikipedia](https://en.wikipedia.org/wiki/Functional_testing)

[Equivalence partitioning - Wikipedia](https://en.wikipedia.org/wiki/Equivalence_partitioning)

[Overview (jsoup Java HTML Parser 1.14.3 API)](https://jsoup.org/apidocs/)
