package fr.arsene.charsheet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableView;
import fr.arsene.charsheet.model.character.Gender;
import fr.arsene.charsheet.model.character.Protection;
import fr.arsene.charsheet.model.game.GameModel;
import fr.arsene.charsheet.services.CharacterService;
import fr.arsene.charsheet.services.GameModelService;
import fr.arsene.charsheet.ui.adapters.ProtectionTable;
import fr.arsene.charsheet.ui.adapters.ProtectionTableItem;
import fr.arsene.charsheet.ui.adapters.WeaponTableItem;
import fr.arsene.charsheet.ui.components.CharacteristicBar;
import fr.arsene.charsheet.ui.components.Dialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxWeaver;
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
    private ProtectionTable protections;

    @FXML
    private JFXTreeTableView<WeaponTableItem> weapons;

    /*
    @FXML
    private JFXTreeTableRow<Item> ;

    @FXML
    private JFXTreeTableRow<Weapon> weapons;
    */

    @Autowired
    private FxWeaver fxWeaver;

    @FXML
    public void initialize() {
        this.comboboxGender.getItems().addAll(Arrays.stream(Gender.values()).map(gender -> new Label(gender.toString())).collect(Collectors.toList()));
        this.comboboxGender.setFocusColor(new Color(50f / 255f, 50 / 255f, 50 / 255f, 1));

        this.protections.add(new Protection("test", "test notes", 12f, 3, 4));

        GameModel model = gameModelService.getGameModel();
        this.comboboxRace.getItems().addAll(model.getRaces().stream().map(race -> new Label(race.getName())).collect(Collectors.toList()));
        this.comboboxProfession.getItems().addAll(model.getProfessions().stream().map(profession -> new Label(profession.getName())).collect(Collectors.toList()));
    }

    @FXML
    private void handleClickSave(ActionEvent event){
        System.out.println(forceBar.getValue());
    }

    @FXML
    private void handleClickAddProtection(ActionEvent event){
        fxWeaver.loadController(Dialog.class).show();
    }
}
