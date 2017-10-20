package bsu.edu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Controller {

    @FXML private SplitMenuButton DesiredLanguage;
    @FXML private SplitMenuButton Language;
    @FXML private TextField Input;
    @FXML private TextArea Output;

    public void exit(ActionEvent actionEvent) {
        Output.setText("Exit will execute");
    }

    public void definition(ActionEvent actionEvent) {
        Parser parser = new Parser();
        String entries = null;
        try {
            URL url = new URL("http://www.dictionaryapi.com/api/v1/references/collegiate/xml/" + Input.getText() +"?key=30d17458-ed0c-4abe-872a-26292fb7e858");
            URLConnection connection = url.openConnection();
            InputStream input = connection.getInputStream();
            entries = parser.parseDefinition(input);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        Output.setText(entries);
    }

    public void urbanDictionary(ActionEvent actionEvent) {
        Output.setText("urbanDictionary definition will go here");
    }

    public void antonyms(ActionEvent actionEvent) {
        Output.setText("antonyms will go here");
    }

    public void synonyms(ActionEvent actionEvent) {
        Output.setText("synonyms will go here");
    }

    public void translate(ActionEvent actionEvent) {
        Parser parser = new Parser();
        String entries = null;
        try {
            URL url = new URL("http://www.dictionaryapi.com/api/v1/references/spanish/xml/" + Input.getText() + "?key=4c237023-8ddb-4781-b1fe-e662581e966f");
            URLConnection connection = url.openConnection();
            InputStream input = connection.getInputStream();
            entries = parser.parseSpanishToEnglish(input);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        Output.setText(entries);
    }
}