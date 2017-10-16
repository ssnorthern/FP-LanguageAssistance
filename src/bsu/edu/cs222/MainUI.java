package bsu.edu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MainUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    private Scene createScene() {
        final TextArea xmlArea = new TextArea();
        final Button button = new Button("Parse");
        final TextField outputField = new TextField();
        outputField.setEditable(false);
        button.setOnAction(event -> {
            Parser parser = new Parser();
            InputStream input = new ByteArrayInputStream(xmlArea.getText().getBytes(StandardCharsets.UTF_8));
            List<Entries> entries = null;
            try {
                entries = parser.parse(input);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(e.getMessage());
                alert.show();
            }
            outputField.setText("There were " + entries.size() + " entries found.");
        });
        return new Scene(new VBox(
                new Label("Enter your XML below."),
                xmlArea,
                button,
                outputField));
    }
}
