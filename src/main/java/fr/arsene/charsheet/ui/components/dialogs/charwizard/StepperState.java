package fr.arsene.charsheet.ui.components.dialogs.charwizard;

public interface StepperState {

    StepperState next();

    StepperState previous();

    void initState();

}
