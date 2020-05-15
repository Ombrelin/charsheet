package fr.arsene.charsheet.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.arsene.charsheet.model.character.Character;
import fr.arsene.charsheet.model.character.Profession;
import fr.arsene.charsheet.model.character.Race;
import fr.arsene.charsheet.model.game.GameModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameModelService {

    private GameModel gameModel;

    public GameModel getGameModel() {

        if (this.gameModel == null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                this.gameModel = mapper.readValue(this.getClass().getClassLoader().getResource("gamemodel.json"), GameModel.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return this.gameModel;
    }

    public List<Profession> getAvailableProfessions(Character character) {
        return this.gameModel
                .getProfessions()
                .stream()
                .filter(profession -> {
                    return
                            character.getCourage() >= profession.getRequirements().getCourageMinThreshold() && character.getCourage() <= profession.getRequirements().getCourageMaxThreshold() &&
                                    character.getIntelligence() >= profession.getRequirements().getIntelligenceMinThreshold() && character.getIntelligence() <= profession.getRequirements().getIntelligenceMaxThreshold() &&
                                    character.getCharisma() >= profession.getRequirements().getCharismaMinThreshold() && character.getCharisma() <= profession.getRequirements().getCharismaMaxThreshold() &&
                                    character.getAgility() >= profession.getRequirements().getAgilityMinThreshold() && character.getAgility() <= profession.getRequirements().getAgilityMaxThreshold() &&
                                    character.getStrength() >= profession.getRequirements().getStrengthMinThreshold() && character.getStrength() <= profession.getRequirements().getStrengthMaxThreshold();
                })
                .collect(Collectors.toList());
    }

    public List<Race> getAvailableRaces(Character character) {
        return this.gameModel
                .getRaces()
                .stream()
                .filter(race -> {
                    return
                            character.getCourage() >= race.getRequirements().getCourageMinThreshold() && character.getCourage() <= race.getRequirements().getCourageMaxThreshold() &&
                                    character.getIntelligence() >= race.getRequirements().getIntelligenceMinThreshold() && character.getIntelligence() <= race.getRequirements().getIntelligenceMaxThreshold() &&
                                    character.getCharisma() >= race.getRequirements().getCharismaMinThreshold() && character.getCharisma() <= race.getRequirements().getCharismaMaxThreshold() &&
                                    character.getAgility() >= race.getRequirements().getAgilityMinThreshold() && character.getAgility() <= race.getRequirements().getAgilityMaxThreshold() &&
                                    character.getStrength() >= race.getRequirements().getStrengthMinThreshold() && character.getStrength() <= race.getRequirements().getStrengthMaxThreshold();
                    
                })
                .collect(Collectors.toList());
    }
}
