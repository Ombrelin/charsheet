package fr.arsene.charsheet.ui.adapters;

import fr.arsene.charsheet.model.character.Ability;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AbilityAdapter {

    public StringProperty name;
    public StringProperty description;

    public AbilityAdapter() {
        this.name = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
    }

    public AbilityAdapter(Ability e) {
        this();
        this.setName(e.getName());
        this.setDescription(e.getNotes());
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

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public Ability toAbility() {
        return new Ability(name.get(), description.get());
    }
}
