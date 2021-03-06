package fr.arsene.charsheet.ui.components.dialogs;

import fr.arsene.charsheet.ui.adapters.ItemAdapter;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class ItemDialog extends AbstractDialog<ItemAdapter> {

    @FXML
    private VBox dialog;

    @FXML
    private TextField name;

    @FXML
    private TextField notes;

    @FXML
    private TextField poids;

    @FXML
    @Override
    public void initialize() {
        super.initialize();
        this.setResult(new ItemAdapter());

        this.getResult().nameProperty().bindBidirectional(name.textProperty());
        this.getResult().notesProperty().bindBidirectional(notes.textProperty());
        Bindings.bindBidirectional(poids.textProperty(), this.getResult().weightProperty(), new NumberStringConverter("###"));

        this.getScene().setRoot(dialog);
    }

}
