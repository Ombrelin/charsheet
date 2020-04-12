package fr.arsene.charsheet.ui.components;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public abstract class Component extends GridPane {

    public Component(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(
                fxml));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
