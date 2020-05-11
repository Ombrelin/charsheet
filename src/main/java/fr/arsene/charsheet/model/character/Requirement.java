package fr.arsene.charsheet.model.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requirement {
    private int courageThreshold;
    private int intelligenceThreshold;
    private int charismaThreshold;
    private int agilityThreshold;
    private int strengthThreshold;
    private int attackThreshold;
    private int blockThreshold;
}
