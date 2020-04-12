package fr.arsene.charsheet.ui.components.dialogs;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.util.function.Consumer;

public abstract class AbstractDialog<T> {

    private Stage stage;
    private Scene scene;
    private Consumer validationHandler;
    private T result;

    public void initialize() {
        this.stage = new Stage();
        this.stage.initModality(Modality.APPLICATION_MODAL);
        this.stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("images/icon.png")));
        this.scene = new Scene(new FlowPane());
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(scene);
        this.stage.setScene(this.scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style.css").toExternalForm());
        scene.getStylesheets().add(getClass().getClassLoader().getResource("theme.css").toExternalForm());
    }

    public void show(Consumer<T> validationHandler) {
        this.validationHandler = validationHandler;
        stage.show();
    }


    @FXML
    public void cancel() {
        this.stage.close();
    }

    @FXML
    public void validate() {
        this.validationHandler.accept(this.result);
        this.stage.close();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
