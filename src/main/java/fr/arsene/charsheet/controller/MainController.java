package fr.arsene.charsheet.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class MainController {

    @FXML
    private JFXComboBox<Label> comboboxGender;


    @FXML
    public void initialize() {
        System.out.println("test");
        this.comboboxGender.getItems().addAll(new Label("Masculin"), new Label("Féminin"));
        this.comboboxGender.setFocusColor(new Color(50f/255f,50/255f,50/255f,1));
    }
}
