package fr.arsene.charsheet.ui.components;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

public abstract class AbstractDialog<T> {

    private Stage stage;
    private Scene scene;
    private Consumer validationHandler;
    private T result;

    public void initialize() {
        this.stage = new Stage();
        this.scene = new Scene(new FlowPane());
        this.stage.setScene(this.scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style.css").toExternalForm());
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
    public void validate(){
        this.validationHandler.accept(this.result);
        this.stage.close();
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
