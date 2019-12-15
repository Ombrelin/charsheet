package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arsene.charsheet.ui.adapters.WeaponAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class WeaponTable extends JFXTreeTableView<WeaponAdapter> {

    private JFXTreeTableColumn<WeaponAdapter, String> nameColumn;
    private JFXTreeTableColumn<WeaponAdapter, String> notesColmun;
    private JFXTreeTableColumn<WeaponAdapter, Float> weightColumn;
    private JFXTreeTableColumn<WeaponAdapter, Integer> breakthoughColumn;
    private JFXTreeTableColumn<WeaponAdapter, Integer> attackColumn;

    private ObservableList<WeaponAdapter> weapons = FXCollections.observableArrayList();

    public WeaponTable() {

        this.nameColumn = new JFXTreeTableColumn<WeaponAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new JFXTreeTableColumn<WeaponAdapter, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new JFXTreeTableColumn<WeaponAdapter, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.breakthoughColumn = new JFXTreeTableColumn<WeaponAdapter, Integer>("Rupture");
        this.breakthoughColumn.setCellValueFactory(param -> param.getValue().getValue().breakthroughProperty().asObject());
        this.breakthoughColumn.setPrefWidth(75);

        this.attackColumn = new JFXTreeTableColumn<WeaponAdapter, Integer>("Dégats");
        this.attackColumn.setCellValueFactory(param -> param.getValue().getValue().damageProperty().asObject());
        this.attackColumn.setPrefWidth(75);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn, breakthoughColumn, attackColumn);
        final TreeItem<WeaponAdapter> root = new RecursiveTreeItem<WeaponAdapter>(this.weapons, RecursiveTreeObject::getChildren);
        this.setRoot(root);
        this.setShowRoot(false);
    }

    public void add(WeaponAdapter e) {
        this.weapons.add(e);
    }

    public void remove(TreeItem<WeaponAdapter> selectedItem) {
        this.weapons.remove(selectedItem);
    }
}
