package fr.arsene.charsheet.ui.components;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class Dialog {
    private Stage stage;

    @FXML
    private VBox dialog;

    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.setScene(new Scene(dialog));
    }

    public void show() {
        stage.show();
    }
}
