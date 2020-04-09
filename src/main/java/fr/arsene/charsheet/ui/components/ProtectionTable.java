package fr.arsene.charsheet.ui.components;

import fr.arsene.charsheet.model.character.Protection;
import fr.arsene.charsheet.ui.adapters.ProtectionAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import java.util.List;
import java.util.stream.Collectors;

public class ProtectionTable extends TreeTableView<ProtectionAdapter> {

    private TreeTableColumn<ProtectionAdapter, String> nameColumn;
    private TreeTableColumn<ProtectionAdapter, String> notesColmun;
    private TreeTableColumn<ProtectionAdapter, Float> weightColumn;
    private TreeTableColumn<ProtectionAdapter, Integer> breakthoughColumn;
    private TreeTableColumn<ProtectionAdapter, Integer> defenseColumn;

    private ObservableList<ProtectionAdapter> protections = FXCollections.observableArrayList();

    public ProtectionTable() {

        this.nameColumn = new TreeTableColumn<ProtectionAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new TreeTableColumn<ProtectionAdapter, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new TreeTableColumn<ProtectionAdapter, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.breakthoughColumn = new TreeTableColumn<ProtectionAdapter, Integer>("Rupture");
        this.breakthoughColumn.setCellValueFactory(param -> param.getValue().getValue().breakthroughProperty().asObject());
        this.breakthoughColumn.setPrefWidth(75);

        this.defenseColumn = new TreeTableColumn<ProtectionAdapter, Integer>("Défense");
        this.defenseColumn.setCellValueFactory(param -> param.getValue().getValue().defenseProperty().asObject());
        this.defenseColumn.setPrefWidth(75);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn, breakthoughColumn, defenseColumn);
    }

    public void add(ProtectionAdapter protection) {
        protections.add(protection);
    }

    public void remove(TreeItem<ProtectionAdapter> selectedItem) {
        protections.remove(selectedItem.getValue());
    }

    public List<Protection> getAll() {
        return this.protections.stream().map(ProtectionAdapter::toProtection).collect(Collectors.toList());
    }

    public void setAll(List<Protection> protections) {
        this.protections.clear();
        for(Protection protection:protections){
            this.add(new ProtectionAdapter(protection));
        }
    }
}
