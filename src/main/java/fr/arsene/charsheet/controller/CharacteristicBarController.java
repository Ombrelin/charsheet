package fr.arsene.charsheet.controller;

import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class CharacteristicBarController {

    @Autowired
    private FxWeaver fxWeaver;

    @FXML
    public void initialize() {

    }

}
