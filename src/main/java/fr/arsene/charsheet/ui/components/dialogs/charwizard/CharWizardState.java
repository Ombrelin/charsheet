package fr.arsene.charsheet.ui.components.dialogs.charwizard;

import fr.arsene.charsheet.ui.components.dialogs.CharWizardDialog;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class CharWizardState implements StepperState {

    @Getter
    private CharWizardDialog controller;

}
