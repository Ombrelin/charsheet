package fr.arsene.charsheet.controller;

import com.jfoenix.controls.*;
import fr.arsene.charsheet.ui.components.CharacteristicBar;
import fr.arsene.charsheet.model.character.Gender;
import fr.arsene.charsheet.model.character.Protection;
import fr.arsene.charsheet.model.character.Weapon;
import fr.arsene.charsheet.model.game.GameModel;
import fr.arsene.charsheet.services.CharacterService;
import fr.arsene.charsheet.services.GameModelService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
    private JFXButton saveButton;

    // Characteristics

    @FXML
    private CharacteristicBar courageBar;

    @FXML
    private CharacteristicBar intellBar;

    @FXML
    private CharacteristicBar charBar;

    @FXML
    private CharacteristicBar adrBar;

    @FXML
    private CharacteristicBar forceBar;

    @FXML
    private CharacteristicBar attackBar;

    @FXML
    private CharacteristicBar blockBar;

    @FXML
    private JFXTreeTableView<Protection> protections;

    @FXML
    private JFXTreeTableView<Weapon> weapons;

    /*
    @FXML
    private JFXTreeTableRow<Item> ;

    @FXML
    private JFXTreeTableRow<Weapon> weapons;
    */

    @FXML
    public void initialize() {
        this.comboboxGender.getItems().addAll(Arrays.stream(Gender.values()).map(gender -> new Label(gender.toString())).collect(Collectors.toList()));
        this.comboboxGender.setFocusColor(new Color(50f / 255f, 50 / 255f, 50 / 255f, 1));


        GameModel model = gameModelService.getGameModel();
        this.comboboxRace.getItems().addAll(model.getRaces().stream().map(race -> new Label(race.getName())).collect(Collectors.toList()));
        this.comboboxProfession.getItems().addAll(model.getProfessions().stream().map(profession -> new Label(profession.getName())).collect(Collectors.toList()));
    }

    @FXML
    private void handleClickSave(ActionEvent event){
        System.out.println(forceBar.getValue());
    }

}
