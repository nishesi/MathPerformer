package ru.kpfu.itis.zaripov.userInterface.GUIversion.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.kpfu.itis.zaripov.userInterface.GUIversion.Scenes.Scenes;

import java.io.IOException;

public class BaseWindowController {

    @FXML
    private Button permutationWindButt;

    @FXML
    private Button combinationWindButt;

    @FXML
    private Button placementWindButt;

    public BaseWindowController() {}

    @FXML
    void openPermutWindow(ActionEvent event) {
        Stage stage = (Stage)permutationWindButt.getScene().getWindow();
        stage.setScene(Scenes.getPermutationScene());
    }

    @FXML
    void openCombinWindow(ActionEvent event) throws IOException {
        Stage stage = (Stage) combinationWindButt.getScene().getWindow();
        stage.setScene(Scenes.getCombinationScene());
    }

    @FXML
    void openPlacemWindow(ActionEvent event) {
        Stage stage = (Stage)placementWindButt.getScene().getWindow();
        stage.setScene(Scenes.getPlacementScene());
    }

}

