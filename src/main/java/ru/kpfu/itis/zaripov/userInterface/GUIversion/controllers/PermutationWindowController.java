package ru.kpfu.itis.zaripov.userInterface.GUIversion.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.kpfu.itis.zaripov.userInterface.GUIversion.Scenes.Scenes;
import ru.kpfu.itis.zaripov.userInterface.GUIversion.controllers.ControllersAdapter.ControllersAdapter;

import java.util.Arrays;

public class PermutationWindowController {

    @FXML
    private Button exitButton;

    @FXML
    private Button computeButton;

    @FXML
    private TextArea resultArea;

    @FXML
    private TextField n;

    @FXML
    private TextField k;

    @FXML
    void compute(ActionEvent event) {
        if (Auxiliary.validatePermutInput(n, k)) {

            String[] repeatsArr = k.getText().split(" ");

            int[] arr = new int[0];

            if (!k.getText().equals("")) {
                arr = Arrays.stream(repeatsArr)
                        .map(Integer::parseInt)
                        .mapToInt(x -> x)
                        .toArray();
            }

            String result = ControllersAdapter.getPermutResult(resultArea, Integer.parseInt(n.getText()), arr);
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
