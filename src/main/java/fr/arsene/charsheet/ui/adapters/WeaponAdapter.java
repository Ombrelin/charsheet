package fr.arsene.charsheet.ui.adapters;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arsene.charsheet.model.character.Weapon;
import javafx.beans.property.*;

public class WeaponAdapter extends RecursiveTreeObject<WeaponAdapter> {

    private StringProperty name;
    private StringProperty notes;
    private FloatProperty weight;
    private IntegerProperty breakthrough;
    private IntegerProperty damage;
    private IntegerProperty refireRate;

    public WeaponAdapter() {
        this.name = new SimpleStringProperty();
        this.notes = new SimpleStringProperty();
        this.weight = new SimpleFloatProperty();
        this.breakthrough = new SimpleIntegerProperty();
        this.damage = new SimpleIntegerProperty();
        this.refireRate = new SimpleIntegerProperty();
    }

    public WeaponAdapter(Weapon w) {
        this.name = new SimpleStringProperty();
        this.notes = new SimpleStringProperty();
        this.weight = new SimpleFloatProperty();
        this.breakthrough = new SimpleIntegerProperty();
        this.damage = new SimpleIntegerProperty();
        this.refireRate = new SimpleIntegerProperty();

        this.setName(w.getName());
        this.setNotes(w.getNotes());
        this.setWeight(w.getWeight());
        this.setBreakthrough(w.getBreakthrough());
        this.setDamage(w.getDamages());
        this.setRefireRate(w.getRefireRate());
    }

    public Weapon toWeapon(){
        return new Weapon(name.get(), notes.get(), weight.get(), breakthrough.get(), damage.get(), refireRate.get());
    }

    public int getRefireRate() {
        return refireRate.get();
    }

    public IntegerProperty refireRateProperty() {
        return refireRate;
    }

    public void setRefireRate(int refireRate) {
        this.refireRate.set(refireRate);
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
