package fr.arsene.charsheet.controller;

import fr.arsene.charsheet.model.character.Character;
import fr.arsene.charsheet.model.character.Gender;
import fr.arsene.charsheet.model.character.Profession;
import fr.arsene.charsheet.model.character.Race;
import fr.arsene.charsheet.model.game.GameModel;
import fr.arsene.charsheet.services.CharacterService;
import fr.arsene.charsheet.services.GameModelService;
import fr.arsene.charsheet.services.RichPresence;
import fr.arsene.charsheet.ui.components.*;
import fr.arsene.charsheet.ui.components.dialogs.*;
import javafx.animation.RotateTransition;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@FxmlView("MainController.fxml")
public class MainController {

    // Services
    private GameModelService gameModelService;

    private CharacterService characterService;

    private FxWeaver fxWeaver;

    public MainController(GameModelService gameModelService, CharacterService characterService, FxWeaver fxWeaver) {
        this.gameModelService = gameModelService;
        this.characterService = characterService;
        this.fxWeaver = fxWeaver;
    }

    // FXML Controls

    @FXML
    private TextField name;

    @FXML
    private ComboBox<String> comboboxGender;

    @FXML
    private ComboBox<String> comboboxRace;

    @FXML
    private ComboBox<String> comboboxProfession;

    @FXML
    private EnergyBar lifeBar;

    @FXML
    private EnergyBar manaBar;

    @FXML
    private Counter golds;

    @FXML
    private Counter silvers;

    @FXML
    private Counter coppers;

    @FXML
    private Counter level;

    @FXML
    private Counter fate;

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
    private CharacteristicBar physBar;

    @FXML
    private CharacteristicBar psyBar;

    @FXML
    private CharacteristicBar resistBar;

    @FXML
    private ProtectionTable protections;

    @FXML
    private WeaponTable weapons;

    @FXML
    private ItemTable items;

    @FXML
    private AbilityTable abilities;

    @FXML
    private ProgressIndicator loader;

    // Dices

    @FXML
    private Label diceResult;

    @FXML
    private Label diceThrow;

    @FXML
    public void initialize() {
        this.comboboxGender.getItems().addAll(Arrays.stream(Gender.values()).map(Enum::name).collect(Collectors.toList()));
        GameModel model = gameModelService.getGameModel();
        this.comboboxRace.getItems().addAll(model.getRaces().stream().map(Race::getName).collect(Collectors.toList()));
        this.comboboxProfession.getItems().addAll(model.getProfessions().stream().map(Profession::getName).collect(Collectors.toList()));

        this.courageBar.valueProperty().addListener(this::updateCalculatedCharacs);
        this.intellBar.valueProperty().addListener(this::updateCalculatedCharacs);
        this.charBar.valueProperty().addListener(this::updateCalculatedCharacs);
        this.adrBar.valueProperty().addListener(this::updateCalculatedCharacs);
        this.forceBar.valueProperty().addListener(this::updateCalculatedCharacs);

        this.loader.setVisible(false);
        this.name.applyCss();
    }

    private void updateCalculatedCharacs(ObservableValue<? extends Number> observableValue, Number object, Number object1) {
        this.physBar.setValue((this.intellBar.getValue() + this.adrBar.getValue()) / 2);
        this.psyBar.setValue((this.intellBar.getValue() + this.charBar.getValue()) / 2);
        this.resistBar.setValue((this.intellBar.getValue() + this.courageBar.getValue() + this.forceBar.getValue()) / 3);
    }

    private Character character = new Character();

    @FXML
    private void handleClickLoad(ActionEvent event) {
        this.loader.setVisible(true);

        this.character = this.characterService.load();
        updateCharacter();
        this.loader.setVisible(false);
        this.updateRichPresence();

    }

    private void updateCharacter() {
        if (this.character != null) {


            // Base
            this.name.setText(character.getName());


            comboboxGender.getSelectionModel().select(comboboxGender.getItems().stream().filter(e -> e.equals(this.character.getGender().toString())).collect(Collectors.toList()).get(0));
            comboboxRace.getSelectionModel().select(comboboxRace.getItems().stream().filter(e -> e.equals(this.character.getRace().getName())).collect(Collectors.toList()).get(0));
            comboboxProfession.getSelectionModel().select(comboboxProfession.getItems().stream().filter(e -> e.equals(this.character.getProfession().getName())).collect(Collectors.toList()).get(0));


            // Energies
            this.lifeBar.setMax(character.getMaxHealth());
            this.manaBar.setMax(character.getMaxMana());
            this.lifeBar.setValue(character.getCurrentHealth());
            this.manaBar.setValue(character.getCurrentMana());

            // Currencies
            this.golds.setBalance(character.getGolds());
            this.silvers.setBalance(character.getSilvers());
            this.coppers.setBalance(character.getCoppers());

            // Fate
            this.fate.setBalance(character.getFatePoints());

            // Level
            this.level.setBalance(character.getExperience());

            // Characteristics
            this.courageBar.setValue(character.getCourage());
            this.intellBar.setValue(character.getIntelligence());
            this.charBar.setValue(character.getCharisma());
            this.adrBar.setValue(character.getAgility());
            this.forceBar.setValue(character.getStrength());
            this.attackBar.setValue(character.getAttack());
            this.blockBar.setValue(character.getBlock());

            // Stuff

            this.weapons.setAll(character.getWeapons());
            this.items.setAll(character.getInventory());
            this.protections.setAll(character.getProtections());

            // Abilities
            this.abilities.setAll(character.getAbilities());

        }
    }

    @FXML
    private void handleClickSave(ActionEvent event) {
        this.loader.setVisible(true);
        GameModel model = gameModelService.getGameModel();

        // Base
        character.setName(this.name.getText());
        if (this.comboboxGender.getSelectionModel().getSelectedItem() != null) {
            character.setGender(Gender.valueOf(this.comboboxGender.getSelectionModel().getSelectedItem()));
        }
        if (comboboxRace.getSelectionModel().getSelectedItem() != null) {
            character.setRace(model.getRaces().stream().filter(e -> e.getName().equals(comboboxRace.getSelectionModel().getSelectedItem())).collect(Collectors.toList()).get(0));

        }
        if (comboboxProfession.getSelectionModel().getSelectedItem() != null) {
            character.setProfession(model.getProfessions().stream().filter(e -> e.getName().equals(comboboxProfession.getSelectionModel().getSelectedItem())).collect(Collectors.toList()).get(0));

        }

        // Energies
        character.setMaxHealth(this.lifeBar.getMax());
        character.setMaxMana(this.manaBar.getMax());
        character.setCurrentHealth(this.lifeBar.getValue());
        character.setCurrentMana(this.manaBar.getValue());


        // Currencies
        character.setGolds(this.golds.getBalance());
        character.setSilvers(this.silvers.getBalance());
        character.setCoppers(this.coppers.getBalance());

        // Fate
        character.setFatePoints(this.fate.getBalance());

        // Level
        character.setExperience(this.level.getBalance());

        // Characteristics
        character.setCourage(this.courageBar.getValue());
        character.setIntelligence(this.intellBar.getValue());
        character.setCharisma(this.charBar.getValue());
        character.setAgility(this.adrBar.getValue());
        character.setStrength(this.forceBar.getValue());
        character.setAttack(this.attackBar.getValue());
        character.setBlock(this.blockBar.getValue());

        // Stuff
        character.setWeapons(this.weapons.getAll());
        character.setInventory(this.items.getAll());
        character.setProtections(this.protections.getAll());

        // Abilities
        character.setAbilities(this.abilities.getAll());

        this.characterService.save(character);
        this.loader.setVisible(false);

        this.updateRichPresence();
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

    @FXML
    public void handleClickAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(alert.getDialogPane().getScene());
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("images/icon.png")));
        stage.getScene().getStylesheets().add(getClass().getClassLoader().getResource("style.css").toExternalForm());
        alert.setTitle("A propos");
        alert.setHeaderText("A propos");
        alert.setContentText("Logiciel developpé par Arsène Lapostolet (https://arsenelapostolet.fr) sous licence Creative Commons Attribution-NonCommercial-ShareAlike");

        alert.showAndWait();
    }

    private void updateRichPresence() {
        if (this.character == null) {
            RichPresence.getINSTANCE().updateMessage("Pas de personnage", "");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.character.getRace().getName());
            sb.append(" ");
            sb.append(this.character.getProfession().getName());
            sb.append(" Niv. ");
            sb.append(this.character.getExperience());
            RichPresence.getINSTANCE().updateMessage(sb.toString(), this.character.getName());
        }
    }

    @FXML
    public void dice(ActionEvent event) {
        Button diceButton = (Button) event.getSource();
        int dicetype = Integer.parseInt(diceButton.getText());

        diceThrow.getStyleClass().clear();
        diceThrow.getStyleClass().addAll(
                diceButton.getStyleClass().filtered(style -> style.contains("dice"))
        );

        diceThrow.setVisible(true);
        diceThrow.pseudoClassStateChanged(PseudoClass.getPseudoClass("thrown"), true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(1000), diceThrow);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();

        rotateTransition.setOnFinished(finished -> {
            diceThrow.setVisible(false);
            Random secureRandom = new SecureRandom();
            this.diceResult.setText(String.valueOf(secureRandom.nextInt(dicetype) + 1));
        });


    }

    @FXML
    private void openCharWizard(ActionEvent event) {
        fxWeaver.loadController(CharWizardDialog.class).show(newCharacter -> {
            this.character = newCharacter;
            this.updateCharacter();
        });
    }
}
