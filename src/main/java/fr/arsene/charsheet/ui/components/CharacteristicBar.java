package fr.arsene.charsheet.ui.components;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class CharacteristicBar extends Component {

    @FXML
    private TextField field;

    @FXML
    private ProgressBar bar;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    private SimpleIntegerProperty value = new SimpleIntegerProperty();
    private SimpleFloatProperty barValue = new SimpleFloatProperty();

    private boolean readonly = false;

    public CharacteristicBar() {
        super("CharacteristicBar.fxml");
        this.bar.progressProperty().bind(this.barValue);
        Bindings.bindBidirectional(this.field.textProperty(), this.value, new NumberStringConverter());

        this.value.addListener(event -> this.barValue.set(this.getValue() / 20f));
        if (this.readonly) {
            this.field.setEditable(false);
            this.minus.setVisible(false);
            this.plus.setVisible(false);
        }
    }

    @FXML
    private void handleClickMinus(ActionEvent event) {
        if (this.valueProperty().get() > 0) {
            this.valueProperty().set(this.valueProperty().get() - 1);
        }
    }

    @FXML
    private void handleClickPlus(ActionEvent event) {
        if (this.valueProperty().get() < 20f) {
            this.valueProperty().set(this.valueProperty().get() + 1);
        }
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
        this.field.setEditable(!readonly);
        this.minus.setVisible(!readonly);
        this.plus.setVisible(!readonly);
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
}
