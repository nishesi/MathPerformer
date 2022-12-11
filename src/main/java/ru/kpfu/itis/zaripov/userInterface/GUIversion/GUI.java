package ru.kpfu.itis.zaripov.userInterface.GUIversion;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.kpfu.itis.zaripov.userInterface.GUIversion.Scenes.Scenes;
import ru.kpfu.itis.zaripov.userInterface.UserInterface;

import java.io.InputStream;

public class GUI extends Application implements UserInterface {
    private Stage primaryStage;

    public void start(String[] args) {
        Application.launch();
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Combinatorics computer");
        this.showBaseWindow();
    }

    protected void showBaseWindow() {

        this.primaryStage.setScene(Scenes.getRootScene());

        InputStream iconStream = this.getClass().getResourceAsStream("/images/icon.png");
        Image image = new Image(iconStream);
        this.primaryStage.getIcons().add(image);

        primaryStage.setMaxHeight(400);
        primaryStage.setMaxWidth(700);
        primaryStage.setResizable(false);

        this.primaryStage.show();
    }
}
