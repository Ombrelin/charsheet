package fr.arsene.charsheet.ui.components.dialogs.charwizard;

import fr.arsene.charsheet.ui.components.dialogs.CharWizardDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import jfxtras.styles.jmetro.FlatAlert;
import jfxtras.styles.jmetro.FlatDialog;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

public class CharacteristicsStep extends CharWizardState {

    public CharacteristicsStep(CharWizardDialog controller) {
        super(controller);
    }

    @Override
    public CharWizardState next() {
        if(this.getController() .getCharacter().getGender() == null){
            alert("Veuillez choisir un genre");
            return this;
        }

        if(this.getController() .getCharacter().getName() == null || this.getController() .getCharacter().getName().equals("")){
            alert("Veuillez choisir un nom");
            return this;
        }

        if(this.getController().getCharacter().getRace() == null &&
            this.getController().getCharacter().getProfession() ==null
        ){
            alert("Veuillez choisir une origine et un métier avant de continer");
            return this;
        }
        else {
            return new AbilitiesStep(this.getController());
        }
    }

    private void alert(String reason) {
        JMetro jMetro = new JMetro(Style.DARK);
        FlatAlert alert = new FlatAlert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Formulaire invalide");
        alert.setContentText(reason);
        jMetro.setScene(alert.getDialogPane().getScene());
        alert.setIconless(true);
        alert.showAndWait();
    }

    @Override
    public CharWizardState previous() {
        throw new IllegalArgumentException("This is the first step");
    }

    @Override
    public void initState() {
        this.getController().getCharacteristicsStep().setManaged(true);
        this.getController().getAbilitiesStep().setManaged(false);
        this.getController().getFateStep().setManaged(false);

        this.getController().getCharacteristicsStep().setVisible(true);
        this.getController().getAbilitiesStep().setVisible(false);
        this.getController().getFateStep().setVisible(false);

        this.getController().getFinishBtn().setVisible(false);
    }
}
