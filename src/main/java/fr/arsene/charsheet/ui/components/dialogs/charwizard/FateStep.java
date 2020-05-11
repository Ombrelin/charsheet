package fr.arsene.charsheet.ui.components.dialogs.charwizard;

import fr.arsene.charsheet.ui.components.dialogs.CharWizardDialog;

public class FateStep extends CharWizardState {
    public FateStep(CharWizardDialog controller) {
        super(controller);
    }

    @Override
    public StepperState next() {
        throw new IllegalArgumentException("This is the last step");

    }

    @Override
    public StepperState previous() {
        return new AbilitiesStep(this.getController());
    }

    @Override
    public void initState() {
        this.getController().getNextBtn().setDisable(true);
        this.getController().getNextBtn().setVisible(false);

        this.getController().getCharacteristicsStep().setManaged(false);
        this.getController().getAbilitiesStep().setManaged(false);
        this.getController().getFateStep().setManaged(true);

        this.getController().getCharacteristicsStep().setVisible(false);
        this.getController().getAbilitiesStep().setVisible(false);
        this.getController().getFateStep().setVisible(true);


        this.getController().getFinishBtn().setVisible(true);

    }
}
