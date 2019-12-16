package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleFloatProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class CharacteristicBar extends Component {

    @FXML
    private TextField field;

    @FXML
    private JFXProgressBar bar;

    @FXML
    private JFXButton plus;

    @FXML
    private JFXButton minus;


    private SimpleFloatProperty value = new SimpleFloatProperty();

    private boolean readonly = false;

    public CharacteristicBar() {
        super("CharacteristicBar.fxml");

//        plus.setGraphic(new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream("images/add.png"), 8, 8, true, true)));
//        minus.setGraphic(new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream("images/remove.png"), 8, 8, true, true)));
//

        bar.progressProperty().bind(this.value);
        if (this.readonly) {
            this.field.setEditable(false);
            this.minus.setVisible(false);
            this.plus.setVisible(false);
        }
    }

    @FXML
    private void handleInput(KeyEvent event) {
        try {
            value.set(Float.parseFloat(field.getText()) / 20f);
        } catch (NumberFormatException exception) {
            field.setText("");
        }
    }

    public float getValue() {
        return value.get() * 20f;
    }

    @FXML
    public void handleClickPlus(ActionEvent event) {
        this.value.set((this.value.get() * 20f + 1f) / 20f);
        this.field.setText(String.valueOf(this.value.get() * 20));
    }

    @FXML
    public void handleClickMinus(ActionEvent event) {
        this.value.set((this.value.get() * 20f - 1f) / 20f);
        this.field.setText(String.valueOf(this.value.get() * 20));
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
}
