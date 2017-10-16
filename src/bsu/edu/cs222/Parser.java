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
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Entries> parse(InputStream input) throws IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IOException(e);
        }
        Document document = builder.parse(input);
        NodeList entryItems = document.getElementsByTagName("entry");
        List<Entries> entries = new ArrayList<>();
        for (int i = 0; i < entryItems.getLength(); i++) {
            entries.add(new Entries());
        }
        return entries;
    }

}
