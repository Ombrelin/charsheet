package fr.arsene.charsheet.ui.components;

import fr.arsene.charsheet.ui.adapters.ProtectionAdapter;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class ProtectionDialog extends AbstractDialog<ProtectionAdapter> {
    @FXML
    private VBox dialog;

    @FXML
    private TextField name;

    @FXML
    private TextField notes;

    @FXML
    private TextField poids;

    @FXML
    private TextField rupture;

    @FXML
    private TextField defense;


    @FXML
    @Override
    public void initialize() {
        super.initialize();
        this.setResult(new ProtectionAdapter());

        this.getResult().nameProperty().bindBidirectional(name.textProperty());
        this.getResult().notesProperty().bindBidirectional(notes.textProperty());
        Bindings.bindBidirectional(poids.textProperty(), this.getResult().weightProperty(), new NumberStringConverter("###"));
        Bindings.bindBidirectional(rupture.textProperty(), this.getResult().breakthroughProperty(), new NumberStringConverter("###"));
        Bindings.bindBidirectional(defense.textProperty(), this.getResult().defenseProperty(), new NumberStringConverter("###"));

        this.getScene().setRoot(dialog);
    }
}
