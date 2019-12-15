package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import fr.arsene.charsheet.ui.events.ValueUpdatedEvent;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleFloatProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public class CharacteristicBar extends Component {

    @FXML
    private JFXTextField field;

    @FXML
    private JFXProgressBar bar;

    @FXML
    private JFXButton plus;

    @FXML
    private JFXButton minus;

    private ObjectProperty<EventHandler<ValueUpdatedEvent>> onValueUpdated = new ObjectPropertyBase<EventHandler<ValueUpdatedEvent>>() {
        @Override
        public Object getBean() {
            return CharacteristicBar.this;
        }


        @Override
        protected void invalidated() {
            setEventHandler(new EventType<>(Event.ANY, "onValueUpdated"), get());
        }


        @Override
        public String getName() {
            return "onValueUpdated";
        }
    };

    private SimpleFloatProperty value = new SimpleFloatProperty();

    private boolean readonly = false;

    public CharacteristicBar() {
        super("CharacteristicBar.fxml");
        value.addListener(
                newValue -> {
                    ValueUpdatedEvent event = new ValueUpdatedEvent();
                    event.setValue(value.get());
                    fireEvent(event);
                }
        );

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

    public EventHandler<ValueUpdatedEvent> getOnValueUpdated() {
        return onValueUpdated.get();
    }

    public ObjectProperty<EventHandler<ValueUpdatedEvent>> onValueUpdatedProperty() {
        return onValueUpdated;
    }

    public void setOnValueUpdated(EventHandler<ValueUpdatedEvent> onValueUpdated) {
        this.onValueUpdated.set(onValueUpdated);
    }
}
