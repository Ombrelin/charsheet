package fr.arsene.charsheet.model.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profession {

    private String name;
    private String notes;
    private Requirement requirements;
    private List<Ability> abilities;
    private List<Ability> possibleAbilities;

    @Override
    public String toString() {
        return this.name;
    }
}
