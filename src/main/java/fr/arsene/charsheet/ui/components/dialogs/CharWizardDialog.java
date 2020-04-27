package fr.arsene.charsheet.ui.components.dialogs;

import fr.arsene.charsheet.ui.components.Dice;
import fr.arsene.charsheet.ui.components.dialogs.charwizard.CharacteristicsStep;
import fr.arsene.charsheet.ui.components.dialogs.charwizard.StepperState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class CharWizardDialog extends AbstractDialog<Character> {

    private StepperState stepperState;

    @FXML
    @Getter
    private AnchorPane dialog;

    @FXML
    @Getter
    private GridPane characteristicsStep;

    @FXML
    @Getter
    private Button nextBtn;

    @FXML
    @Getter
    private Button prevBtn;

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

    // ====================== Dices results ==========================

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

    // ====================== Characteristics finale score ==========================


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
    }

    private Label draggedLabel;

    @FXML
    private void handleDrag(MouseEvent mouseEvent) {
        Label source = (Label) mouseEvent.getSource();
        source.startFullDrag();
        this.draggedLabel = source;
        System.out.println("drag");
    }

    @FXML
    private void handleDrop(MouseDragEvent event) {
        Label target = (Label) event.getSource();
        String content = draggedLabel.getText();
        draggedLabel.setText("");
        target.setText(content);
        System.out.println("drop");
    }

    @FXML
    private void handlePress(MouseEvent event) {
        event.setDragDetect(true);
        System.out.println("drag detected");
    }

    @FXML
    private void next(ActionEvent event) {
        this.stepperState.next();
    }

    @FXML
    private void previous(ActionEvent event) {
        this.stepperState.previous();
    }


}
