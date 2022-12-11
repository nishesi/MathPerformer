package ru.kpfu.itis.zaripov.userInterface.GUIversion.controllers.ControllersAdapter;

import javafx.scene.control.TextArea;
import ru.kpfu.itis.zaripov.core.BigCombinatorialFunctions;

public class ControllersAdapter {


    public static String getPermutResult(TextArea textArea, int n, int ... repeats) {
        return BigCombinatorialFunctions.permutation(n, repeats).toString();
    }

    public static String getCombinResult(int n, int k, boolean withRepeats) {
        return BigCombinatorialFunctions.combination(n, k, withRepeats).toString();
    }

    public static String getPlacemResult(int n, int k, boolean withRepeats) {
        return BigCombinatorialFunctions.placement(n, k, withRepeats).toString();
    }

}
