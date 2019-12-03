package fr.arsene.charsheet;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CharsheetApplication {

    public static void main(String[] args) {
        Application.launch(CharsheetFX.class, args);
    }

}
