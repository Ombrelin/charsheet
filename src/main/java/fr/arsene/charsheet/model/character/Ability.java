package fr.arsene.charsheet.model.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ability {
    private String name;
    private String notes;

    @Override
    public String toString() {
        return name;
    }
}
