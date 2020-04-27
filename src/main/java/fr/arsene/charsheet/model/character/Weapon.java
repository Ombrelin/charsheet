package fr.arsene.charsheet.model.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Weapon extends Equipment {

    private int damages;
    private int refireRate;

    public Weapon(String name, String notes, float weight, int breakthrough, int damages, int refireRate) {
        super(name, notes, weight, breakthrough);
        this.damages = damages;
        this.refireRate = refireRate;
    }
}
