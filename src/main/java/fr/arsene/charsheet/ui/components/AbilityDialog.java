package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXTextField;
import fr.arsene.charsheet.ui.adapters.AbilityAdapter;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@FxmlView
@Component
public class AbilityDialog extends AbstractDialog<AbilityAdapter> {

    @FXML
    private VBox dialog;

    @FXML
    JFXTextField name;

    @FXML
    JFXTextField description;

    @FXML
    @Override
    public void initialize() {
        super.initialize();
        this.setResult(new AbilityAdapter());

        this.getResult().nameProperty().bindBidirectional(name.textProperty());
        this.getResult().descriptionProperty().bindBidirectional(description.textProperty());

        this.getScene().setRoot(dialog);
    }

}
