### Jsoup Introduction

[Jsoup](https://jsoup.org/) is a HTML parser developed in Java. The total number of LOC is 39K. The main Functions are below:

- parse HTML from URL, File and strings.   

- output tidy HTML 

- use DOm traversal or CSS selectors to find data

- manipulate the HTML elements, attributes, and text

- clean user-submitted content against a safelist, to prevent XSS attacks

### Building

##### Requirement:

- Java 8 or newer versions

- Elicpse or IntelliJ

We fork the [Jsoup](https://github.com/jhy/jsoup/) repository in GitHub. And import the repository to our private repository. Then we git clone our repository locally.

```shell
git clone https://github.com/jhy/jsoup.git
cd jsoup
mvn install
```

That will run the unit and integration tests. We can also use the command line below to test the existing test files. This example is to test parsing attributes.

```
mvn test -D test=org.jsoup.parser.AttributeParseTest
```

### Existing Test Files

we use this command line to show the test files in java

```
find . -print | sed -e 's;*/;|____;g;s;____|; |;g'
```

The structure of test files shows below:

![](/Users/chenwenjun/workplace/261SoftwareTesing/image/img.png)

The original project uses Junit Test. Here we use the maven test command line to test all files. 


