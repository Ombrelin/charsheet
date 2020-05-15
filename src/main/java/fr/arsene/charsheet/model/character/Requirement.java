package fr.arsene.charsheet.model.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requirement {
    private int courageMinThreshold;
    private int intelligenceMinThreshold;
    private int charismaMinThreshold;
    private int agilityMinThreshold;
    private int strengthMinThreshold;

    private int courageMaxThreshold;
    private int intelligenceMaxThreshold;
    private int charismaMaxThreshold;
    private int agilityMaxThreshold;
    private int strengthMaxThreshold;
}
