package fr.arsene.charsheet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import fr.arsene.charsheet.model.character.Gender;
import fr.arsene.charsheet.model.game.GameModel;
import fr.arsene.charsheet.services.CharacterService;
import fr.arsene.charsheet.services.GameModelService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@FxmlView("MainController.fxml")
public class MainController {

    // Services

    @Autowired
    GameModelService gameModelService;

    @Autowired
    CharacterService characterService;

    // FXML Controls

    @FXML
    private JFXComboBox<Label> comboboxGender;

    @FXML
    private JFXComboBox<Label> comboboxRace;

    @FXML
    private JFXComboBox<Label> comboboxProfession;

    @FXML
    private CharacteristicBarController forceCharBar;

    // Characteristics

      /*

    @FXML
    private JFXTextField forceField;

    @FXML
    private JFXProgressBar forceBar;

    @FXML
    private JFXTextField intelligenceField;

    @FXML
    private JFXProgressBar intelligenceBar;


    @FXML
    private JFXTextField courageField;

    @FXML
    private JFXProgressBar courageBar;

    @FXML
    private JFXTextField charismaField;

    @FXML
    private JFXProgressBar charismaBar;

    @FXML
    private JFXTextField agilityField;

    @FXML
    private JFXProgressBar agilityBar;

    @FXML
    private JFXTextField attackField;

    @FXML
    private JFXProgressBar attackBar;

    @FXML
    private JFXTextField blockField;

    @FXML
    private JFXProgressBar blockBar;

    // Properties


    private SimpleFloatProperty forceProperty = new SimpleFloatProperty();
    private SimpleFloatProperty intelligenceProperty = new SimpleFloatProperty();
    private SimpleFloatProperty courageProperty = new SimpleFloatProperty();
    private SimpleFloatProperty charismaProperty = new SimpleFloatProperty();
    private SimpleFloatProperty agilityProperty = new SimpleFloatProperty();
    private SimpleFloatProperty attackProperty = new SimpleFloatProperty();
    private SimpleFloatProperty blockProperty = new SimpleFloatProperty();

     */

    // Control maps

    private Map<JFXTextField, JFXProgressBar> fieldBarMap = new HashMap<>();

    @FXML
    public void initialize() {
        this.comboboxGender.getItems().addAll(Arrays.stream(Gender.values()).map(gender -> new Label(gender.toString())).collect(Collectors.toList()));
        this.comboboxGender.setFocusColor(new Color(50f / 255f, 50 / 255f, 50 / 255f, 1));

        /*
        forceBar.progressProperty().bind(forceProperty);
        intelligenceBar.progressProperty().bind(intelligenceProperty);
        courageBar.progressProperty().bind(courageProperty);
        charismaBar.progressProperty().bind(charismaProperty);
        agilityBar.progressProperty().bind(agilityProperty);
        attackBar.progressProperty().bind(attackProperty);
        blockBar.progressProperty().bind(blockProperty);
         fieldBarMap.put(forceField, forceBar);

        */




        GameModel model = gameModelService.getGameModel();
        this.comboboxRace.getItems().addAll(model.getRaces().stream().map(race -> new Label(race.getName())).collect(Collectors.toList()));
        this.comboboxProfession.getItems().addAll(model.getProfessions().stream().map(profession -> new Label(profession.getName())).collect(Collectors.toList()));
    }


    private void handleChangeCharacteristic(KeyEvent event) {
        /*
        try {
            this.courageProperty.set(Integer.parseInt(field.getText()) / 20f);
        } catch (NumberFormatException e) {
            field.setText("0");
        }

         */
    }
}
