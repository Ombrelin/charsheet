package fr.arsene.charsheet.ui.adapters;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class WeaponAdapter extends RecursiveTreeObject<WeaponAdapter> {

    private StringProperty name;
    private StringProperty notes;
    private FloatProperty weight;
    private IntegerProperty breakthrough;
    private IntegerProperty damage;

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

    public int getDamage() {
        return damage.get();
    }

    public IntegerProperty damageProperty() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage.set(damage);
    }
}
