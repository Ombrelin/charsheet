package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleFloatProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class CharacteristicBar extends GridPane {

    @FXML
    private JFXTextField field;

    @FXML
    private JFXProgressBar bar;

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

        bar.progressProperty().bind(this.value);
    }

    @FXML
    private void handleInput(KeyEvent event) {
        try{
            value.set(Float.parseFloat(field.getText()) / 20f);
        }
        catch(NumberFormatException exception) {
            field.setText("");
        }
    }

    public float getValue() {
        return value.get() * 20f;
    }

    @FXML
    public void handleClickPlus(ActionEvent event){
        this.value.set((this.value.get() * 20f + 1f) / 20f);
        this.field.setText(String.valueOf(this.value.get() * 20));
    }

    @FXML
    public void handleClickMinus(ActionEvent event){
        this.value.set((this.value.get() * 20f - 1f) / 20f);
        this.field.setText(String.valueOf(this.value.get() * 20));
    }
}
