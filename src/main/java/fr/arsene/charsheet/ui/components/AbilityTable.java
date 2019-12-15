package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arsene.charsheet.ui.adapters.AbilityAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class AbilityTable extends JFXTreeTableView<AbilityAdapter> {


    private JFXTreeTableColumn<AbilityAdapter, String> nameColumn;
    private JFXTreeTableColumn<AbilityAdapter, String> notesColmun;
    private ObservableList<AbilityAdapter> items = FXCollections.observableArrayList();

    public AbilityTable() {

        this.nameColumn = new JFXTreeTableColumn<AbilityAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new JFXTreeTableColumn<AbilityAdapter, String>("Description");
        this.notesColmun.setCellValueFactory(param -> param.getValue().getValue().descriptionProperty());
        this.notesColmun.setPrefWidth(150);

        this.getColumns().setAll(nameColumn, notesColmun);
        final TreeItem<AbilityAdapter> root = new RecursiveTreeItem<AbilityAdapter>(this.items, RecursiveTreeObject::getChildren);
        this.setRoot(root);
        this.setShowRoot(false);
    }

    public void add(AbilityAdapter item) {
        items.add(item);
    }

    public void remove(TreeItem<AbilityAdapter> selectedItem) {
        items.remove(selectedItem.getValue());
    }


}
