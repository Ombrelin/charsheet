package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arsene.charsheet.model.character.Protection;
import fr.arsene.charsheet.ui.adapters.ProtectionAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProtectionTable extends JFXTreeTableView<ProtectionAdapter> {

    private JFXTreeTableColumn<ProtectionAdapter, String> nameColumn;
    private JFXTreeTableColumn<ProtectionAdapter, String> notesColmun;
    private JFXTreeTableColumn<ProtectionAdapter, Float> weightColumn;
    private JFXTreeTableColumn<ProtectionAdapter, Integer> breakthoughColumn;
    private JFXTreeTableColumn<ProtectionAdapter, Integer> defenseColumn;

    private ObservableList<ProtectionAdapter> protections = FXCollections.observableArrayList();

    public ProtectionTable() {

        this.nameColumn = new JFXTreeTableColumn<ProtectionAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new JFXTreeTableColumn<ProtectionAdapter, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new JFXTreeTableColumn<ProtectionAdapter, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.breakthoughColumn = new JFXTreeTableColumn<ProtectionAdapter, Integer>("Rupture");
        this.breakthoughColumn.setCellValueFactory(param -> param.getValue().getValue().breakthroughProperty().asObject());
        this.breakthoughColumn.setPrefWidth(75);

        this.defenseColumn = new JFXTreeTableColumn<ProtectionAdapter, Integer>("Défense");
        this.defenseColumn.setCellValueFactory(param -> param.getValue().getValue().defenseProperty().asObject());
        this.defenseColumn.setPrefWidth(75);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn, breakthoughColumn, defenseColumn);
        final TreeItem<ProtectionAdapter> root = new RecursiveTreeItem<ProtectionAdapter>(this.protections, RecursiveTreeObject::getChildren);
        this.setRoot(root);
        this.setShowRoot(false);
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
