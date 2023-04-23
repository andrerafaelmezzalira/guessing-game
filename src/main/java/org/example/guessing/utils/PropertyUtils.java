package org.example.guessing.utils;

import java.util.ResourceBundle;

import static java.lang.Thread.currentThread;
import static java.util.Locale.getDefault;
import static java.util.ResourceBundle.getBundle;

public class PropertyUtils {

    public static ResourceBundle readProperties() {
        return getBundle("application", getDefault(), currentThread().getContextClassLoader());
    }
}
