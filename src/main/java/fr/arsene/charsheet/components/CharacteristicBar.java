package fr.arsene.charsheet.components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleFloatProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class CharacteristicBar extends FlowPane {

    @FXML
    private JFXTextField field;

    private SimpleFloatProperty value = new SimpleFloatProperty();

    public CharacteristicBar() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(
                "CharacteristicBar.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void handleInput(KeyEvent event) {
        value.set(Float.parseFloat(field.getText()) / 20f);
        System.out.println(field.getText());
    }

    public float getValue() {
        float val = value.get() * 20;
        System.out.println(val);
        return val;
    }
}
