package ru.kpfu.itis.zaripov.userInterface.GUIversion.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.kpfu.itis.zaripov.userInterface.GUIversion.Scenes.Scenes;
import ru.kpfu.itis.zaripov.userInterface.GUIversion.controllers.ControllersAdapter.ControllersAdapter;

public class PlacementWindowController {

    @FXML
    private Button exitButton;

    @FXML
    private Button computeButton;

    @FXML
    private TextField n;

    @FXML
    private TextField k;

    @FXML
    private CheckBox isWithRepeats;

    @FXML
    void compute(ActionEvent event) {
        if (Auxiliary.validateNKInput(n, k, isWithRepeats)) {

            String result = ControllersAdapter.getPlacemResult(
                    Integer.parseInt(n.getText()),
                    Integer.parseInt(k.getText()),
                    isWithRepeats.isSelected()
            );

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "result = " + result);
            alert.show();

        }
    }

    @FXML
    void goBack(ActionEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.setScene(Scenes.getRootScene());
    }

}
