package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXTextField;
import fr.arsene.charsheet.ui.adapters.WeaponAdapter;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class WeaponDialog extends AbstractDialog<WeaponAdapter> {

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
    JFXTextField damage;

    @FXML
    @Override
    public void initialize() {
        super.initialize();
        this.setResult(new WeaponAdapter());

        this.getResult().nameProperty().bindBidirectional(name.textProperty());
        this.getResult().notesProperty().bindBidirectional(notes.textProperty());
        Bindings.bindBidirectional(poids.textProperty(), this.getResult().weightProperty(), new NumberStringConverter("###"));
        Bindings.bindBidirectional(rupture.textProperty(), this.getResult().breakthroughProperty(), new NumberStringConverter("###"));
        Bindings.bindBidirectional(damage.textProperty(), this.getResult().damageProperty(), new NumberStringConverter("###"));

        this.getScene().setRoot(dialog);
    }

}
