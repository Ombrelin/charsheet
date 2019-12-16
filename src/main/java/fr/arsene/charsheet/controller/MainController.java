package fr.arsene.charsheet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import fr.arsene.charsheet.model.character.Gender;
import fr.arsene.charsheet.model.game.GameModel;
import fr.arsene.charsheet.services.CharacterService;
import fr.arsene.charsheet.services.GameModelService;
import fr.arsene.charsheet.ui.components.*;
import fr.arsene.charsheet.ui.events.ValueUpdatedEvent;
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
    private WeaponTable weapons;

    @FXML
    private ItemTable items;

    @FXML
    private AbilityTable abilities;

    @Autowired
    private FxWeaver fxWeaver;

    @FXML
    public void initialize() {
        this.comboboxGender.getItems().addAll(Arrays.stream(Gender.values()).map(gender -> new Label(gender.toString())).collect(Collectors.toList()));
        this.comboboxGender.setFocusColor(new Color(50f / 255f, 50 / 255f, 50 / 255f, 1));

        GameModel model = gameModelService.getGameModel();
        this.comboboxRace.getItems().addAll(model.getRaces().stream().map(race -> new Label(race.getName())).collect(Collectors.toList()));
        this.comboboxProfession.getItems().addAll(model.getProfessions().stream().map(profession -> new Label(profession.getName())).collect(Collectors.toList()));
    }

    @FXML
    private void handleClickSave(ActionEvent event) {
        System.out.println(forceBar.getValue());
    }

    @FXML
    private void handleClickAddProtection(ActionEvent event) {
        fxWeaver.loadController(ProtectionDialog.class).show(e -> {
            this.protections.add(e);
        });
    }

    @FXML
    public void handleClickRemoveProtection(ActionEvent actionEvent) {
        this.protections.remove(this.protections.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void handleClickAddWeapon(ActionEvent actionEvent) {
        fxWeaver.loadController(WeaponDialog.class).show(e -> {
            this.weapons.add(e);
        });
    }

    @FXML
    public void handleClickRemoveWeapon(ActionEvent actionEvent) {
        this.weapons.remove(this.weapons.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void handleClickAddItem(ActionEvent actionEvent) {
        fxWeaver.loadController(ItemDialog.class).show(e -> {
            this.items.add(e);
        });
    }

    @FXML
    public void handleClickRemoveItem(ActionEvent actionEvent) {
        this.items.remove(this.items.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void handleClickAddAbility(ActionEvent actionEvent) {
        fxWeaver.loadController(AbilityDialog.class).show(e -> {
            this.abilities.add(e);
        });
    }

    @FXML
    public void handleClickRemoveAbility(ActionEvent actionEvent) {
        this.abilities.remove(this.abilities.getSelectionModel().getSelectedItem());
    }
}
