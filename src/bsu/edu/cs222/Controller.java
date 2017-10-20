package bsu.edu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    // Working implementation
    /*
    public void definition(ActionEvent actionEvent) {
        Parser parser = new Parser();
        InputStream input = new ByteArrayInputStream(Input.getText().getBytes(StandardCharsets.UTF_8));
        List<Entries> entries = null;
        try {
            entries = parser.parse(input);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        Output.setText("There were " + entries.size() + " entries found.");
    }
    */

    // Work-in-progress
    public void definition(ActionEvent actionEvent) {
        Parser parser = new Parser();
        InputStream input = new ByteArrayInputStream(Input.getText().getBytes(StandardCharsets.UTF_8));
        List<Entries> headword = null;
        try {
            headword = parser.parse(input);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        Output.setText("There were " + headword + " entries found.");
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
        Output.setText("translate will go here");
    }
}