package fr.arsene.charsheet.ui.components.dialogs;

import fr.arsene.charsheet.model.character.Ability;
import fr.arsene.charsheet.model.character.Character;
import fr.arsene.charsheet.model.character.Profession;
import fr.arsene.charsheet.model.character.Race;
import fr.arsene.charsheet.services.GameModelService;
import fr.arsene.charsheet.ui.components.Dice;
import fr.arsene.charsheet.ui.components.dialogs.charwizard.CharacteristicsStep;
import fr.arsene.charsheet.ui.components.dialogs.charwizard.StepperState;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
@FxmlView
public class CharWizardDialog extends AbstractDialog<Character> {

    // Services & Data

    private GameModelService gameModelService;
    private Character character = new Character();

    public CharWizardDialog(GameModelService gameModelService) {
        this.gameModelService = gameModelService;
    }

    // Controls

    @FXML
    private TextField name;

    private StepperState stepperState;

    @FXML
    @Getter
    private AnchorPane dialog;

    @FXML
    @Getter
    private VBox characteristicsStep;

    @FXML
    @Getter
    private VBox abilitiesStep;

    @FXML
    @Getter
    private VBox fateStep;

    @FXML
    @Getter
    private Button nextBtn;

    @FXML
    @Getter
    private Button finishBtn;


    // ====================== Dices ==========================

    @FXML
    private Dice dice1;

    @FXML
    private Dice dice2;

    @FXML
    private Dice dice3;

    @FXML
    private Dice dice4;

    @FXML
    private Dice dice5;

    // ================================ Dices results ===================================

    @FXML
    private Label dice1CharResult;


    @FXML
    private Label dice2CharResult;


    @FXML
    private Label dice3CharResult;


    @FXML
    private Label dice4CharResult;


    @FXML
    private Label dice5CharResult;

    // =========================== Characteristics finale score =============================


    @FXML
    private Label courageFinalScore;

    @FXML
    private Label intelligenceFinalScore;

    @FXML
    private Label charismeFinalScore;

    @FXML
    private Label forceFinalScore;

    @FXML
    private Label adresseFinalScore;

    @FXML
    @Override
    public void initialize() {
        super.initialize();
        this.name.applyCss();
        this.getScene().setRoot(dialog);

        stepperState = new CharacteristicsStep(this);
        stepperState.initState();

        dice1.getScore().addListener((obs, oldV, newV) -> {
            this.dice1CharResult.setText(Integer.toString(newV.intValue() + 7));
            this.dice1.setVisible(false);
        });
        dice2.getScore().addListener((obs, oldV, newV) -> {
            this.dice2CharResult.setText(Integer.toString(newV.intValue() + 7));
            this.dice2.setVisible(false);
        });
        dice3.getScore().addListener((obs, oldV, newV) -> {
            this.dice3CharResult.setText(Integer.toString(newV.intValue() + 7));
            this.dice3.setVisible(false);
        });
        dice4.getScore().addListener((obs, oldV, newV) -> {
            this.dice4CharResult.setText(Integer.toString(newV.intValue() + 7));
            this.dice4.setVisible(false);
        });
        dice5.getScore().addListener((obs, oldV, newV) -> {
            this.dice5CharResult.setText(Integer.toString(newV.intValue() + 7));
            this.dice5.setVisible(false);
        });

        this.name.textProperty().addListener((observable, oldValue, newValue) -> {
            this.character.setName(newValue);
        });

        this.professionsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.racesList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        this.racesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.character.setRace(newValue);
        });
        this.professionsList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.character.setProfession(newValue);
        });

        this.abilitiesFromOrigin.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.abilitiesFromProfession.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        this.destinyDice.getScore().addListener((observable, oldValue, newValue) -> {
            int result = newValue.intValue() - 1;
            this.destinyResult.setText(Integer.toString(result));
            this.character.setFatePoints(result);
            this.destinyDice.setVisible(false);
        });
    }

    private Label draggedLabel;

    @FXML
    private void handleDrag(MouseEvent mouseEvent) {
        Label source = (Label) mouseEvent.getSource();
        source.startFullDrag();
        this.draggedLabel = source;
    }

    @FXML
    private void handleDrop(MouseDragEvent event) {
        Label target = (Label) event.getSource();
        if (target.getText().equals("")) {
            String content = draggedLabel.getText();
            draggedLabel.setText("");
            target.setText(content);

            this.updateCharacteristics();
            this.updateCharacteristics();
            this.updateOriginAndProfessions();
            this.character.setRace(null);
            this.character.setProfession(null);
        }
    }

    private void updateCharacteristics() {
        this.setResult(this.character);
        this.character.setCourage(this.courageFinalScore.getText().equals("") ? 8 : Integer.parseInt(this.courageFinalScore.getText()));
        this.character.setIntelligence(this.intelligenceFinalScore.getText().equals("") ? 8 : Integer.parseInt(this.intelligenceFinalScore.getText()));
        this.character.setCharisma(this.charismeFinalScore.getText().equals("") ? 8 : Integer.parseInt(this.charismeFinalScore.getText()));
        this.character.setAgility(this.adresseFinalScore.getText().equals("") ? 8 : Integer.parseInt(this.adresseFinalScore.getText()));
        this.character.setStrength(this.forceFinalScore.getText().equals("") ? 8 : Integer.parseInt(this.forceFinalScore.getText()));

    }

    @FXML
    private void handlePress(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void next(ActionEvent event) {
        this.stepperState = this.stepperState.next();
        this.stepperState.initState();
    }

    @FXML
    private void handleClickFinish(ActionEvent event) {
        this.character.setAbilities(new LinkedList<>());
        this.character.getAbilities().clear();
        this.character.getAbilities().addAll(this.abilitiesFromOrigin.getSelectionModel().getSelectedItems());
        this.character.getAbilities().addAll(this.abilitiesFromProfession.getSelectionModel().getSelectedItems());
        this.validate();
    }

    // ================================ List views =================================

    @FXML
    private ListView<Race> racesList;

    @FXML
    private ListView<Profession> professionsList;

    private void updateOriginAndProfessions() {
        racesList.setItems(FXCollections.observableList(this.gameModelService.getAvailableRaces(this.character)));
        professionsList.setItems(FXCollections.observableList(this.gameModelService.getAvailableProfessions(this.character)));
    }

    // ============================= Abilities =====================================

    @FXML
    private ListView<Ability> abilitiesFromOrigin;

    @FXML
    private ListView<Ability> abilitiesFromProfession;

    public void handleChangeAbilitiesFromOrigin(MouseEvent mouseEvent) {
        if (this.abilitiesFromOrigin.getSelectionModel().getSelectedItems().size() > 3) {
            this.abilitiesFromOrigin.getSelectionModel().clearSelection(3);
        }
    }

    public void handleChangeAbilitiesFromProfession(MouseEvent mouseEvent) {
        if (this.abilitiesFromProfession.getSelectionModel().getSelectedItems().size() > 3) {
            this.abilitiesFromProfession.getSelectionModel().clearSelection(3);
        }
    }

    // =============================== Destiny ==================================

    @FXML
    private Dice destinyDice;

    @FXML
    private Label destinyResult;
}
