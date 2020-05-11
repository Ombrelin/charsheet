package fr.arsene.charsheet.ui.components;

import fr.arsene.charsheet.model.character.Protection;
import fr.arsene.charsheet.ui.adapters.ProtectionAdapter;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.stream.Collectors;

public class ProtectionTable extends TableView<ProtectionAdapter> {

    private TableColumn<ProtectionAdapter, String> nameColumn;
    private TableColumn<ProtectionAdapter, String> notesColmun;
    private TableColumn<ProtectionAdapter, Float> weightColumn;
    private TableColumn<ProtectionAdapter, Integer> breakthoughColumn;
    private TableColumn<ProtectionAdapter, Integer> defenseColumn;

    public ProtectionTable() {

        this.nameColumn = new TableColumn<ProtectionAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new TableColumn<ProtectionAdapter, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new TableColumn<ProtectionAdapter, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.breakthoughColumn = new TableColumn<ProtectionAdapter, Integer>("Rupture");
        this.breakthoughColumn.setCellValueFactory(param -> param.getValue().breakthroughProperty().asObject());
        this.breakthoughColumn.setPrefWidth(75);

        this.defenseColumn = new TableColumn<ProtectionAdapter, Integer>("Défense");
        this.defenseColumn.setCellValueFactory(param -> param.getValue().defenseProperty().asObject());
        this.defenseColumn.setPrefWidth(75);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn, breakthoughColumn, defenseColumn);
    }

    public void add(ProtectionAdapter protection) {
        this.itemsProperty().getValue().add(protection);
    }

    public void remove(ProtectionAdapter selectedItem) {
        this.itemsProperty().getValue().remove(selectedItem);
    }

    public List<Protection> getAll() {
        return this.itemsProperty().getValue().stream().map(ProtectionAdapter::toProtection).collect(Collectors.toList());
    }

    public void setAll(List<Protection> protections) {
        this.itemsProperty().getValue().clear();
        for (Protection protection : protections) {
            this.add(new ProtectionAdapter(protection));
        }
    }
}
