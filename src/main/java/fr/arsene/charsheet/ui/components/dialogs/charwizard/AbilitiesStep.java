package fr.arsene.charsheet.ui.components.dialogs.charwizard;

import fr.arsene.charsheet.ui.components.dialogs.CharWizardDialog;

public class AbilitiesStep extends CharWizardState {
    public AbilitiesStep(CharWizardDialog controller) {
        super(controller);
    }

    @Override
    public CharWizardState next() {
        return new FateStep(this.getController());
    }

    @Override
    public CharWizardState previous() {
        return new CharacteristicsStep(this.getController());
    }

    @Override
    public void initState() {
        this.getController().getNextBtn().setDisable(false);

        this.getController().getCharacteristicsStep().setManaged(false);
        this.getController().getAbilitiesStep().setManaged(true);
        this.getController().getFateStep().setManaged(false);

        this.getController().getCharacteristicsStep().setVisible(false);
        this.getController().getAbilitiesStep().setVisible(true);
        this.getController().getFateStep().setVisible(false);
        this.getController().getFinishBtn().setVisible(false);
    }
}
