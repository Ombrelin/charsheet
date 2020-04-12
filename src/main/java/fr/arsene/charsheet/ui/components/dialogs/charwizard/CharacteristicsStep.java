package fr.arsene.charsheet.ui.components.dialogs.charwizard;

import fr.arsene.charsheet.ui.components.dialogs.CharWizardDialog;

public class CharacteristicsStep extends CharWizardState {

    public CharacteristicsStep(CharWizardDialog controller) {
        super(controller);
    }

    @Override
    public void next() {

    }

    @Override
    public void previous() {
        throw new IllegalArgumentException("This is the first step");
    }

    @Override
    public void initState() {
        this.getController().getCharacteristicsStep().setVisible(true);
        this.getController().getPrevBtn().setDisable(true);
    }
}
