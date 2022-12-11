package ru.kpfu.itis.zaripov.main;

import ru.kpfu.itis.zaripov.userInterface.GUIversion.GUI;
import ru.kpfu.itis.zaripov.userInterface.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new GUI();
        userInterface.start(args);
    }
}
