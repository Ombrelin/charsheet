package fr.arsene.charsheet.ui.components;

import fr.arsene.charsheet.model.character.Item;
import fr.arsene.charsheet.ui.adapters.ItemAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.stream.Collectors;

public class ItemTable extends TableView<ItemAdapter> {

    private TableColumn<ItemAdapter, String> nameColumn;
    private TableColumn<ItemAdapter, String> notesColmun;
    private TableColumn<ItemAdapter, Float> weightColumn;

    public ItemTable() {

        this.nameColumn = new TableColumn<ItemAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new TableColumn<ItemAdapter, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new TableColumn<ItemAdapter, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn);
    }

    public void add(ItemAdapter item) {
        this.itemsProperty().getValue().add(item);
    }

    public void remove(ItemAdapter selectedItem) {
        itemsProperty().getValue().remove(selectedItem);
    }

    public List<Item> getAll() {
        return this.itemsProperty().getValue().stream().map(ItemAdapter::toItem).collect(Collectors.toList());
    }

    public void setAll(List<Item> inventory) {
        this.itemsProperty().getValue().clear();
        for(Item item:inventory){
            this.itemsProperty().getValue().add(new ItemAdapter(item));
        }
    }
}
