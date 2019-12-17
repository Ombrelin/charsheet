package fr.arsene.charsheet.ui.components;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arsene.charsheet.model.character.Item;
import fr.arsene.charsheet.ui.adapters.ItemAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ItemTable extends JFXTreeTableView<ItemAdapter> {

    private JFXTreeTableColumn<ItemAdapter, String> nameColumn;
    private JFXTreeTableColumn<ItemAdapter, String> notesColmun;
    private JFXTreeTableColumn<ItemAdapter, Float> weightColumn;
    private ObservableList<ItemAdapter> items = FXCollections.observableArrayList();

    public ItemTable() {

        this.nameColumn = new JFXTreeTableColumn<ItemAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new JFXTreeTableColumn<ItemAdapter, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new JFXTreeTableColumn<ItemAdapter, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn);
        final TreeItem<ItemAdapter> root = new RecursiveTreeItem<ItemAdapter>(this.items, RecursiveTreeObject::getChildren);
        this.setRoot(root);
        this.setShowRoot(false);
    }

    public void add(ItemAdapter item) {
        items.add(item);
    }

    public void remove(TreeItem<ItemAdapter> selectedItem) {
        items.remove(selectedItem.getValue());
    }

    public List<Item> getAll() {
        return this.items.stream().map(ItemAdapter::toItem).collect(Collectors.toList());
    }

    public void setAll(List<Item> inventory) {
        this.items.clear();
        for(Item item:inventory){
            this.items.add(new ItemAdapter(item));
        }
    }
}
