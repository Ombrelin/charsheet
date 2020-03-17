package fr.arsene.charsheet.ui.components;

import fr.arsene.charsheet.model.character.Weapon;
import fr.arsene.charsheet.ui.adapters.WeaponAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import java.util.List;
import java.util.stream.Collectors;

public class WeaponTable extends TreeTableView<WeaponAdapter> {

    private TreeTableColumn<WeaponAdapter, Integer> refireColumn;
    private TreeTableColumn<WeaponAdapter, String> nameColumn;
    private TreeTableColumn<WeaponAdapter, String> notesColmun;
    private TreeTableColumn<WeaponAdapter, Float> weightColumn;
    private TreeTableColumn<WeaponAdapter, Integer> breakthoughColumn;
    private TreeTableColumn<WeaponAdapter, Integer> attackColumn;

    private ObservableList<WeaponAdapter> weapons = FXCollections.observableArrayList();

    public WeaponTable() {

        this.nameColumn = new TreeTableColumn<WeaponAdapter, String>("Nom");
        this.nameColumn.setCellValueFactory(param -> param.getValue().getValue().nameProperty());
        this.nameColumn.setPrefWidth(140);

        this.notesColmun = new TreeTableColumn<WeaponAdapter, String>("Notes");
        this.notesColmun.setCellValueFactory(param -> param.getValue().getValue().notesProperty());
        this.notesColmun.setPrefWidth(150);

        this.weightColumn = new TreeTableColumn<WeaponAdapter, Float>("Poids");
        this.weightColumn.setCellValueFactory(param -> param.getValue().getValue().weightProperty().asObject());
        this.weightColumn.setPrefWidth(50);

        this.breakthoughColumn = new TreeTableColumn<WeaponAdapter, Integer>("Rupture");
        this.breakthoughColumn.setCellValueFactory(param -> param.getValue().getValue().breakthroughProperty().asObject());
        this.breakthoughColumn.setPrefWidth(75);

        this.attackColumn = new TreeTableColumn<WeaponAdapter, Integer>("Dégats");
        this.attackColumn.setCellValueFactory(param -> param.getValue().getValue().damageProperty().asObject());
        this.attackColumn.setPrefWidth(75);

        this.refireColumn = new TreeTableColumn<WeaponAdapter, Integer>("Cadence");
        this.refireColumn.setCellValueFactory(param -> param.getValue().getValue().refireRateProperty().asObject());
        this.refireColumn.setPrefWidth(75);

        this.getColumns().setAll(nameColumn, notesColmun, weightColumn, breakthoughColumn, attackColumn, refireColumn);
        this.setShowRoot(false);
    }

    public void add(WeaponAdapter e) {
        this.weapons.add(e);
    }

    public void remove(TreeItem<WeaponAdapter> selectedItem) {
        this.weapons.remove(selectedItem);
    }

    public List<Weapon> getAll(){
        return this.weapons.stream().map(WeaponAdapter::toWeapon).collect(Collectors.toList());
    }

    public void setAll(List<Weapon> weapons) {
        this.weapons.clear();
        for(Weapon weapon:weapons){
            this.weapons.add(new WeaponAdapter(weapon));
        }
    }
}
