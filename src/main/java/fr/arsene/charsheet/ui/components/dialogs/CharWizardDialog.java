package fr.arsene.charsheet.ui.components.dialogs;

import fr.arsene.charsheet.ui.components.Dice;
import fr.arsene.charsheet.ui.components.dialogs.charwizard.CharacteristicsStep;
import fr.arsene.charsheet.ui.components.dialogs.charwizard.StepperState;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML
    private Dice courageDice;

    @FXML
    private Dice intelligenceDice;

    @FXML
    private Dice charismeDice;

    @FXML
    private Dice forceDice;

    @FXML
    private Dice adresseDice;

    @FXML
    @Override
    public void initialize() {
        super.initialize();
        this.getScene().setRoot(dialog);

        stepperState = new CharacteristicsStep(this);
        stepperState.initState();

        courageDice.getScore().addListener(this::courageScoreChanged);
    }

    public void courageScoreChanged(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

    }

    @FXML
    private void next(ActionEvent event){
        this.stepperState.next();
    }

    @FXML
    private void previous(ActionEvent event){
        this.stepperState.previous();
    }


}
