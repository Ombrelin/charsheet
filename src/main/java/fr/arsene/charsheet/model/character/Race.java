package fr.arsene.charsheet.model.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Race {

    private String name;
    private String notes;
    private Requirement requirement;
    private List<Ability> abilities;

}
