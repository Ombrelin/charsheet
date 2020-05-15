package fr.arsene.charsheet.ui.components;

import javafx.animation.RotateTransition;
import javafx.beans.NamedArg;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.Random;

public class Dice extends Component {

    @FXML
    private Button diceIcon;

    @FXML
    private Label diceResult;

    @Getter
    @Setter
    private Integer faceCount;

    @Getter
    private IntegerProperty score = new SimpleIntegerProperty();

    public Dice(@NamedArg("faceCount") Integer faceCount) {
        super("Dice.fxml");
        this.faceCount = faceCount;
        this.diceIcon.getStyleClass().add("dice" + faceCount);
    }

    @FXML
    private void roll(ActionEvent event) {

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(1000), diceIcon);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        rotateTransition.setOnFinished(finished -> {
            Random secureRandom = new SecureRandom();
            this.score.set(secureRandom.nextInt(faceCount) + 1);
            this.diceResult.setText(String.valueOf(this.score.getValue()));
        });

    }
}
