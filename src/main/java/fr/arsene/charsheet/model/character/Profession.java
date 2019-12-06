package fr.arsene.charsheet.model.character;

public class Profession {

    private String name;
    private String notes;

    public Profession() {
    }

    public Profession(String name, String notes) {
        this.name = name;
        this.notes = notes;
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
}
