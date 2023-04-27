package org.example.guessing.utils;

import org.example.guessing.GuessingGame;
import org.example.guessing.Node;

import java.util.ResourceBundle;

import static java.lang.Thread.currentThread;
import static java.util.Locale.getDefault;
import static java.util.ResourceBundle.getBundle;

public class GuessingGameUtils {

    private static GuessingGame guessingGame;
    private static final ResourceBundle resourceBundle = readProperties();

    public static GuessingGame getGuessingGame() {
        if (guessingGame == null) {
            guessingGame = buildGuessingGame();
        }
        return guessingGame;
    }

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    private static ResourceBundle readProperties() {
        return getBundle("application", getDefault(), currentThread().getContextClassLoader());
    }

    private static GuessingGame buildGuessingGame() {
        return new GuessingGame(buildRoot());
    }

    private static Node buildRoot() {
        String root = resourceBundle.getString("guessing.root");
        String next = resourceBundle.getString("guessing.next");
        String other = resourceBundle.getString("guessing.other");
        return Node.of(root, next, other);
    }
}
