package ru.kpfu.itis.zaripov.userInterface.GUIversion.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class Auxiliary {




    public static boolean validateNKInput(TextField nText, TextField kText, CheckBox checkBox) {
        String mess = null;

        try {
            int n = Integer.parseInt(nText.getText());
            int k = Integer.parseInt(kText.getText());

            if (n < 0 || k < 0) {
                mess =  "n and k should be not negative";

            } else if (!checkBox.isSelected() && k > n) {
                mess = "k should be not bigger than n";
            }

        } catch (NumberFormatException ex) {
            mess = "you enter to n or k not a integer number";
        }

        if (mess != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, mess);
            alert.show();
            return false;
        }
        return true;
    }

    public static boolean validatePermutInput(TextField nText, TextField repeats) {
        String mess = null;

        try {
            int n = Integer.parseInt(nText.getText());

            if (n < 0) {
                mess = "n should be not negative";
            }
            if (!repeats.getText().equals("")) {
                String[] repeatsArr = repeats.getText().split(" ");


                int[] arr = Arrays.stream(repeatsArr)
                        .map(Integer::parseInt)
                        .mapToInt(x -> x)
                        .toArray();

                if (Arrays.stream(arr).sum() > n) {
                    mess = "sum of repetitions should be not bigger than n";
                } else {
                    for (int k : arr) {
                        if (k < 0) {
                            mess = "repetitions should be not negative";
                            break;
                        }
                    }
                }
            }

        } catch (NumberFormatException ex) {
            mess = "you enter to n or k not a integer number";
        }

        if (mess != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, mess);
            alert.show();
            return false;
        }
        return true;

    };
}
