package fr.arsene.charsheet.model.character;

public class Weapon extends Equipment {

    private int damages;
    private int refireRate;

    public Weapon(String name, String notes, float weight, int breakthrough, int damages, int refireRate) {
        super(name, notes, weight, breakthrough);
        this.damages = damages;
        this.refireRate = refireRate;
    }

    public int getDamages() {
        return damages;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }
}
