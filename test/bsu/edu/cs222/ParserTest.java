package bsu.edu.cs222;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ParserTest {

    @Test
    public void testParse() throws IOException, SAXException {
        Parser parser = new Parser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.xml");
        List<Entries> entries = parser.parse(inputStream);
        Assert.assertEquals(4, entries.size());
    }
}
