package fr.arsene.charsheet.model.character;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Equipment extends Item {
    public Equipment(String name, String notes, float weight, int breakthrough) {
        super(name, notes, weight);
        this.breakthrough = breakthrough;
    }

    private int breakthrough;
}
