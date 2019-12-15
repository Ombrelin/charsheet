package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.converter.NumberStringConverter;

public class Counter extends Component {

    @FXML
    private Label label;

    @FXML
    private JFXTextField field;

    private IntegerProperty balance = new SimpleIntegerProperty();

    private StringProperty name = new SimpleStringProperty();

    public Counter() {
        super("Counter.fxml");
        Bindings.bindBidirectional(this.field.textProperty(), balance, new NumberStringConverter("###"));
        this.label.textProperty().bind(this.name);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getBalance() {
        return balance.get();
    }

    public IntegerProperty balanceProperty() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance.set(balance);
    }
}
