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
                            character.getCourage() >= profession.getRequirement().getCourageThreshold() &&
                                    character.getIntelligence() >= profession.getRequirement().getIntelligenceThreshold() &&
                                    character.getCharisma() >= profession.getRequirement().getCharismaThreshold() &&
                                    character.getAgility() >= profession.getRequirement().getAgilityThreshold() &&
                                    character.getStrength() >= profession.getRequirement().getStrengthThreshold();
                })
                .collect(Collectors.toList());
    }

    public List<Race> getAvailableRaces(Character character) {
        return this.gameModel
                .getRaces()
                .stream()
                .filter(race -> {
                    return
                            character.getCourage() >= race.getRequirement().getCourageThreshold() &&
                                    character.getIntelligence() >= race.getRequirement().getIntelligenceThreshold() &&
                                    character.getCharisma() >= race.getRequirement().getCharismaThreshold() &&
                                    character.getAgility() >= race.getRequirement().getAgilityThreshold() &&
                                    character.getStrength() >= race.getRequirement().getStrengthThreshold();
                })
                .collect(Collectors.toList());
    }
}
