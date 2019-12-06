package fr.arsene.charsheet.model.character;

public class Item {

    private String name;
    private String notes;
    private float weight;

    public Item(String name, String notes, float weight) {
        this.name = name;
        this.notes = notes;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
