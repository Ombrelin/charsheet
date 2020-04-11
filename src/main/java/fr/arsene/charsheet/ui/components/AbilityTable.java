package fr.arsene.charsheet.ui.components;

import fr.arsene.charsheet.model.character.Ability;
import fr.arsene.charsheet.ui.adapters.AbilityAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.List;
import java.util.stream.Collectors;

public class AbilityTable extends TableView<AbilityAdapter> {


    private TableColumn<AbilityAdapter, String> nameColumn;
    private TableColumn<AbilityAdapter, String> notesColmun;

    public AbilityTable() {

        this.nameColumn = new TableColumn<AbilityAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new TableColumn<AbilityAdapter, String>("Description");
        this.notesColmun.setCellValueFactory(param -> param.getValue().descriptionProperty());
        this.notesColmun.setPrefWidth(150);

        this.getColumns().setAll(nameColumn, notesColmun);
    }

    public void add(AbilityAdapter item) {
        this.itemsProperty().getValue().add(item);
    }

    public void remove(AbilityAdapter selectedItem) {
        itemsProperty().getValue().remove(selectedItem);
    }


    public List<Ability> getAll() {
        return this.itemsProperty().getValue().stream().map(AbilityAdapter::toAbility).collect(Collectors.toList());
    }

    public void setAll(List<Ability> abilities) {
        this.itemsProperty().getValue().clear();
        for(Ability ability:abilities){
            this.itemsProperty().getValue().addAll(new AbilityAdapter(ability));
        }
    }
}
