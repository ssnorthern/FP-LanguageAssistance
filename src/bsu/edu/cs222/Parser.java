package bsu.edu.cs222;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Parser {

    public String parseSpanishToEnglish(InputStream input) throws IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IOException(e);
        }
        Document document = builder.parse(input);
        NodeList entryItems = document.getElementsByTagName("entry");
        Element entry = (Element)entryItems.item(0);
        NodeList refLinks = entry.getElementsByTagName("ref-link");
        Element refLink = (Element)refLinks.item(0);
        return refLink.getTextContent();
    }

    public String parseDefinition(InputStream input) throws IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IOException(e);
        }
        Document document = builder.parse(input);
        NodeList entryItems = document.getElementsByTagName("entry");
        Element entry = (Element)entryItems.item(0);
        NodeList dts = entry.getElementsByTagName("dt");
        Element dt = (Element)dts.item(0);
        return dt.getTextContent();
    }
}
