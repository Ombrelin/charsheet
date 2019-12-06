package fr.arsene.charsheet.model.character;

public abstract class Equipment extends Item {

    private int breakthrough;


    public Equipment(String name, String notes, float weight, int breakthrough) {
        super(name, notes, weight);
        this.breakthrough = breakthrough;
    }

    public int getBreakthrough() {
        return breakthrough;
    }

    public void setBreakthrough(int breakthrough) {
        this.breakthrough = breakthrough;
    }
}
