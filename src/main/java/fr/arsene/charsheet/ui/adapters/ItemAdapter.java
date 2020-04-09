package fr.arsene.charsheet.ui.adapters;

import fr.arsene.charsheet.model.character.Item;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemAdapter {

    private StringProperty name;
    private StringProperty notes;
    private FloatProperty weight;

    public ItemAdapter() {
        this.name = new SimpleStringProperty();
        this.notes = new SimpleStringProperty();
        this.weight = new SimpleFloatProperty();
    }

    public ItemAdapter(Item item) {
        this();
        this.setName(item.getName());
        this.setNotes(item.getNotes());
        this.setWeight(item.getWeight());
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public float getWeight() {
        return weight.get();
    }

    public FloatProperty weightProperty() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight.set(weight);
    }

    public Item toItem() {
        return new Item(name.get(), notes.get(), weight.get());
    }
}
