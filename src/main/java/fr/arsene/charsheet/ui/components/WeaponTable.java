package fr.arsene.charsheet.ui.components;

import fr.arsene.charsheet.model.character.Weapon;
import fr.arsene.charsheet.ui.adapters.WeaponAdapter;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.stream.Collectors;

public class WeaponTable extends TableView<WeaponAdapter> {

    private TableColumn<WeaponAdapter, Integer> refireColumn;
    private TableColumn<WeaponAdapter, String> nameColumn;
    private TableColumn<WeaponAdapter, String> notesColmun;
    private TableColumn<WeaponAdapter, Float> weightColumn;
    private TableColumn<WeaponAdapter, Integer> breakthoughColumn;
    private TableColumn<WeaponAdapter, Integer> attackColumn;

    public WeaponTable() {

        this.nameColumn = new TableColumn<WeaponAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new TableColumn<WeaponAdapter, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new TableColumn<WeaponAdapter, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.breakthoughColumn = new TableColumn<WeaponAdapter, Integer>("Rupture");
        this.breakthoughColumn.setCellValueFactory(param -> param.getValue().breakthroughProperty().asObject());
        this.breakthoughColumn.setPrefWidth(75);

        this.attackColumn = new TableColumn<WeaponAdapter, Integer>("Dégats");
        this.attackColumn.setCellValueFactory(param -> param.getValue().damageProperty().asObject());
        this.attackColumn.setPrefWidth(75);

        this.refireColumn = new TableColumn<WeaponAdapter, Integer>("Cadence");
        this.refireColumn.setCellValueFactory(param -> param.getValue().refireRateProperty().asObject());
        this.refireColumn.setPrefWidth(75);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn, breakthoughColumn, attackColumn, refireColumn);
    }

    public void add(WeaponAdapter e) {
        this.itemsProperty().getValue().add(e);
    }

    public void remove(WeaponAdapter selectedItem) {
        this.itemsProperty().getValue().remove(selectedItem);
    }

    public List<Weapon> getAll() {
        return this.itemsProperty().getValue().stream().map(WeaponAdapter::toWeapon).collect(Collectors.toList());
    }

    public void setAll(List<Weapon> weapons) {
        this.itemsProperty().getValue().clear();
        for (Weapon weapon : weapons) {
            this.add(new WeaponAdapter(weapon));
        }
    }
}
