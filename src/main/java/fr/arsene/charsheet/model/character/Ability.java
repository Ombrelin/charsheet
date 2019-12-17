package fr.arsene.charsheet.model.character;

public class Ability {

    private String name;
    private String description;

    public Ability(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Ability() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
