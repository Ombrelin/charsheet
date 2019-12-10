package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXProgressBar;
import javafx.beans.property.SimpleFloatProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class EnergyBar extends GridPane {

    private String name;
    private SimpleFloatProperty value = new SimpleFloatProperty();
    private int max;

    @FXML
    private JFXProgressBar bar;

    @FXML
    private Label label;

    public EnergyBar() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(
                "EnergyBar.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.label.setText(this.getName());
        this.bar.progressProperty().bind(this.value);
    }

    @FXML
    private void handleClickMinus(ActionEvent event) {
        if (this.valueProperty().get() > 1f / this.max) {
            this.valueProperty().set(this.valueProperty().get() - (1f / this.max));
        }
    }

    @FXML
    private void handleClickPlus(ActionEvent event) {
        this.valueProperty().set(this.valueProperty().get() + (1f / this.max));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value.get();
    }

    public SimpleFloatProperty valueProperty() {
        return value;
    }

    public void setValue(float value) {
        this.value.set(value);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
