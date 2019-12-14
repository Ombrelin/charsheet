package fr.arsene.charsheet.ui.adapters;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arsene.charsheet.model.character.Protection;
import javafx.beans.property.*;

public class ProtectionAdapter extends RecursiveTreeObject<ProtectionAdapter> {

    private StringProperty name;
    private StringProperty notes;
    private FloatProperty weight;
    private IntegerProperty breakthrough;
    private IntegerProperty defense;

    public ProtectionAdapter(){
        this.name = new SimpleStringProperty();
        this.notes = new SimpleStringProperty();
        this.weight = new SimpleFloatProperty();
        this.breakthrough = new SimpleIntegerProperty();
        this.defense = new SimpleIntegerProperty();
    }

    public ProtectionAdapter(Protection protection) {
        this.name = new SimpleStringProperty(protection.getName());
        this.notes = new SimpleStringProperty(protection.getNotes());
        this.weight = new SimpleFloatProperty(protection.getWeight());
        this.breakthrough = new SimpleIntegerProperty(protection.getBreakthrough());
        this.defense = new SimpleIntegerProperty(protection.getDefense());
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

    public int getBreakthrough() {
        return breakthrough.get();
    }

    public IntegerProperty breakthroughProperty() {
        return breakthrough;
    }

    public void setBreakthrough(int breakthrough) {
        this.breakthrough.set(breakthrough);
    }

    public int getDefense() {
        return defense.get();
    }

    public IntegerProperty defenseProperty() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense.set(defense);
    }
}
