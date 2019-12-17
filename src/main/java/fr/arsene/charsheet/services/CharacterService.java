package fr.arsene.charsheet.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.arsene.charsheet.model.character.Character;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class CharacterService {

    private FileChooser fileChooser;
    private ObjectMapper mapper = new ObjectMapper();
    private File file;

    private FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CHARSHEET files (*.charsheet)", "*.charsheet");


    public CharacterService() {
        this.fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(extFilter);
    }

    public void save(Character character) {
        if(this.file == null){
            this.file = fileChooser.showSaveDialog(new Stage());
        }


        if (file != null) {
            try {
                mapper.writeValue(file, character);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public Character load(){
        this.file = fileChooser.showOpenDialog(new Stage());
        if(this.file != null){
            try {
                return mapper.readValue(this.file, Character.class);
            } catch (IOException e) {
                e.printStackTrace();
                return new Character();
            }
        }
        return null;
    }


}
