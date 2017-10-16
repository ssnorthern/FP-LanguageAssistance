package bsu.edu.cs222;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class XmlLearningTest {

    private Document document;

    @Before
    public void setUp() throws ParserConfigurationException, IOException, SAXException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(inputStream);
    }

    @Test
    public void testParse() {
        NodeList entryListItems = document.getElementsByTagName("entry_list");
        Assert.assertEquals(1, entryListItems.getLength());
    }

    @Test
    public void testReadEntryListElement() {
        NodeList children = document.getChildNodes();
        Element EntryListElement = (Element)children.item(0);
        Assert.assertEquals("entry_list", EntryListElement.getNodeName());
    }

    @Test
    public void testReadFirstEntryItemHeadword() {
        NodeList items = document.getElementsByTagName("entry");
        Element firstItem = (Element)items.item(0);
        NodeList headwords = firstItem.getElementsByTagName("hw");
        Element headword = (Element)headwords.item(0);
        Assert.assertEquals("test", headword.getTextContent());
    }
}
