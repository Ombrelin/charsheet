package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXTextField;
import fr.arsene.charsheet.model.character.Protection;
import fr.arsene.charsheet.ui.adapters.ProtectionAdapter;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@FxmlView
public class ProtectionDialog extends AbstractDialog<ProtectionAdapter> {
    @FXML
    private VBox dialog;

    @FXML
    JFXTextField name;

    @FXML
    JFXTextField notes;

    @FXML
    JFXTextField poids;

    @FXML
    JFXTextField rupture;

    @FXML
    JFXTextField defense;


    @FXML
    @Override
    public void initialize() {
        super.initialize();
        this.setResult(new ProtectionAdapter());

        this.getResult().nameProperty().bindBidirectional(name.textProperty());
        this.getResult().notesProperty().bindBidirectional(notes.textProperty());
        Bindings.bindBidirectional(poids.textProperty(),this.getResult().weightProperty(), new NumberStringConverter("###"));
        Bindings.bindBidirectional(rupture.textProperty(),this.getResult().breakthroughProperty(), new NumberStringConverter("###"));
        Bindings.bindBidirectional(defense.textProperty(),this.getResult().defenseProperty(), new NumberStringConverter("###"));

        this.getScene().setRoot(dialog);
    }
}
