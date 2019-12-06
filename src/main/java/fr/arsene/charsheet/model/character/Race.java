package fr.arsene.charsheet.model.character;

public class Race {

    private String name;
    private String notes;

    public Race() {
    }

    public Race(String name, String notes) {
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
