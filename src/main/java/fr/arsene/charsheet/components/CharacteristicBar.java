package fr.arsene.charsheet.components;

import fr.arsene.charsheet.controller.CharacteristicBarController;
import javafx.scene.Group;
import javafx.scene.Node;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;


public class CharacteristicBar extends Group {

    @Autowired
    FxWeaver fxWeaver;

    public CharacteristicBar() {
        Node n = fxWeaver.loadView(CharacteristicBarController.class);
        this.getChildren().add(n);
    }
}
