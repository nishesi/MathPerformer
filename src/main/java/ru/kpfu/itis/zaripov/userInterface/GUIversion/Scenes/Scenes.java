package ru.kpfu.itis.zaripov.userInterface.GUIversion.Scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import ru.kpfu.itis.zaripov.userInterface.GUIversion.GUI;

import java.io.IOException;

public class Scenes {
    private static final Scene[] scenes = new Scene[4];

    public static Scene getRootScene() {
        if (scenes[0] == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUI.class.getResource("/maket/RootWindow.fxml"));
            try {
                scenes[0] = new Scene(loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return scenes[0];
    }

    public static Scene getPermutationScene() {
        if (scenes[1] == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUI.class.getResource("/maket/PermutationWindow.fxml"));
            try {
                scenes[1] = new Scene(loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return scenes[1];
    }
    public static Scene getCombinationScene() {
        if (scenes[2] == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUI.class.getResource("/maket/CombinationWindow.fxml"));
            try {
                scenes[2] = new Scene(loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return scenes[2];
    }
    public static Scene getPlacementScene() {
        if (scenes[3] == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUI.class.getResource("/maket/PlacementWindow.fxml"));
            try {
                scenes[3] = new Scene(loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return scenes[3];
    }
}
