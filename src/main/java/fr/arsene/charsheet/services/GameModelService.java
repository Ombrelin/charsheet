package fr.arsene.charsheet.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.arsene.charsheet.model.game.GameModel;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

}
