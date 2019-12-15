package fr.arsene.charsheet.ui.events;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;

public class ValueUpdatedEvent extends Event {

    public static final EventType<ActionEvent> VALUE =
            new EventType<>(Event.ANY, "VALUE_UPDATED");

    private float value;

    public ValueUpdatedEvent() {
        super(VALUE);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
