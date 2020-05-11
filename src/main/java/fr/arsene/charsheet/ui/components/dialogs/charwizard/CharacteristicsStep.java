package fr.arsene.charsheet.ui.components.dialogs.charwizard;

import fr.arsene.charsheet.ui.components.dialogs.CharWizardDialog;

public class CharacteristicsStep extends CharWizardState {

    public CharacteristicsStep(CharWizardDialog controller) {
        super(controller);
    }

    @Override
    public CharWizardState next() {
        return new AbilitiesStep(this.getController());
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
