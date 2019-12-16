package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class EnergyBar extends Component {

    private String name;
    private SimpleIntegerProperty value = new SimpleIntegerProperty();
    private SimpleIntegerProperty max = new SimpleIntegerProperty();
    private SimpleFloatProperty barValue = new SimpleFloatProperty();

    @FXML
    private JFXProgressBar bar;

    @FXML
    private TextField field;

    @FXML
    TextField maxField;

    public EnergyBar() {
        super("EnergyBar.fxml");
        this.bar.progressProperty().bind(this.barValue);
        Bindings.bindBidirectional(this.maxField.textProperty(), this.max, new NumberStringConverter());
        Bindings.bindBidirectional(this.field.textProperty(), this.value, new NumberStringConverter());

        this.value.addListener(event -> this.barValue.set(this.getValue() / (float) this.getMax()));
    }

    @FXML
    private void handleClickMinus(ActionEvent event) {
        if (this.valueProperty().get() > 0) {
            this.valueProperty().set(this.valueProperty().get() - 1);
        }
    }

    @FXML
    private void handleClickPlus(ActionEvent event) {
        if (this.valueProperty().get() < this.max.get()) {
            this.valueProperty().set(this.valueProperty().get() + 1);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value.get();
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }

    public void setValue(int value) {
        this.value.set(value);
    }

    public int getMax() {
        return max.get();
    }

    public SimpleIntegerProperty maxProperty() {
        return max;
    }

    public void setMax(int max) {
        this.max.set(max);
    }
}
