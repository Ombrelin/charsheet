package fr.arsene.charsheet.model.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Protection extends Equipment {

    public Protection(String name, String notes, float weight, int breakthrough, int defense) {
        super(name, notes, weight, breakthrough);
        this.defense = defense;
    }

    private int defense;

}
