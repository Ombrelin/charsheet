package fr.arsene.charsheet.ui.adapters;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arsene.charsheet.model.character.Protection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class ProtectionTable extends JFXTreeTableView<ProtectionTableItem> {

    private JFXTreeTableColumn<ProtectionTableItem, String> nameColumn;
    private JFXTreeTableColumn<ProtectionTableItem, String> notesColmun;
    private JFXTreeTableColumn<ProtectionTableItem, Float> weightColumn;
    private JFXTreeTableColumn<ProtectionTableItem, Integer> breakthoughColumn;
    private JFXTreeTableColumn<ProtectionTableItem, Integer> defenseColumn;

    private ObservableList<ProtectionTableItem> protections = FXCollections.observableArrayList();

    public ProtectionTable() {

        this.nameColumn = new JFXTreeTableColumn<ProtectionTableItem, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new JFXTreeTableColumn<ProtectionTableItem, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new JFXTreeTableColumn<ProtectionTableItem, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.breakthoughColumn = new JFXTreeTableColumn<ProtectionTableItem, Integer>("Rupture");
        this.breakthoughColumn.setCellValueFactory(param -> param.getValue().getValue().breakthroughProperty().asObject());
        this.breakthoughColumn.setPrefWidth(75);

        this.defenseColumn = new JFXTreeTableColumn<ProtectionTableItem, Integer>("Défense");
        this.defenseColumn.setCellValueFactory(param -> param.getValue().getValue().defenseProperty().asObject());
        this.defenseColumn.setPrefWidth(75);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn, breakthoughColumn, defenseColumn);
        final TreeItem<ProtectionTableItem> root = new RecursiveTreeItem<ProtectionTableItem>(this.protections, RecursiveTreeObject::getChildren);
        this.setRoot(root);
        this.setShowRoot(false);
    }

    public void add(Protection protection){
        protections.add(new ProtectionTableItem(protection));
    }
}
