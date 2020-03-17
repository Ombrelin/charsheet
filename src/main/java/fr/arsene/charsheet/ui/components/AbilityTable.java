package fr.arsene.charsheet.ui.components;

import fr.arsene.charsheet.model.character.Ability;
import fr.arsene.charsheet.ui.adapters.AbilityAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import java.util.List;
import java.util.stream.Collectors;

public class AbilityTable extends TreeTableView<AbilityAdapter> {


    private TreeTableColumn<AbilityAdapter, String> nameColumn;
    private TreeTableColumn<AbilityAdapter, String> notesColmun;
    private ObservableList<AbilityAdapter> items = FXCollections.observableArrayList();

    public AbilityTable() {

        this.nameColumn = new TreeTableColumn<AbilityAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new TreeTableColumn<AbilityAdapter, String>("Description");
        this.notesColmun.setCellValueFactory(param -> param.getValue().getValue().descriptionProperty());
        this.notesColmun.setPrefWidth(150);

        this.getColumns().setAll(nameColumn, notesColmun);
    }

    public void add(AbilityAdapter item) {
        items.add(item);
    }

    public void remove(TreeItem<AbilityAdapter> selectedItem) {
        items.remove(selectedItem.getValue());
    }


    public List<Ability> getAll() {
        return this.items.stream().map(AbilityAdapter::toAbility).collect(Collectors.toList());
    }

    public void setAll(List<Ability> abilities) {
        this.items.clear();
        for(Ability ability:abilities){
            this.items.addAll(new AbilityAdapter(ability));
        }
    }
}
