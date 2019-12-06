package fr.arsene.charsheet.model.character;

public class Protection extends Equipment {

    private int defense;

    public Protection(String name, String notes, float weight, int breakthrough, int defense) {
        super(name, notes, weight, breakthrough);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
