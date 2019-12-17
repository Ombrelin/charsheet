package fr.arsene.charsheet.ui.components;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class Counter extends Component {

    @FXML
    private Label label;

    @FXML
    private TextField field;

    private IntegerProperty balance = new SimpleIntegerProperty();

    private StringProperty name = new SimpleStringProperty();

    public Counter() {
        super("Counter.fxml");
        Bindings.bindBidirectional(this.field.textProperty(), balance, new NumberStringConverter("###"));
        this.label.textProperty().bind(this.name);
    }

    @FXML
    public void handleClickMinus(ActionEvent event) {
        this.setBalance(this.getBalance() - 1);
    }

    @FXML
    public void handleClickPlus(ActionEvent event) {
        this.setBalance(this.getBalance() + 1);
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
