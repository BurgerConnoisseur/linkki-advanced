package de.faktorzehn.ui;

import java.time.Year;

import org.linkki.framework.ui.application.ApplicationInfo;

public class LinkkiAdvancedInfo implements ApplicationInfo {

    public static final String APPLICATION_NAME = "LinkkiAdvanced";

    @Override
    public String getApplicationName() {
        return APPLICATION_NAME;
    }

    @Override
    public String getApplicationVersion() {
        return "1.0";
    }

    @Override
    public String getApplicationDescription() {
        return "LinkkiAdvanced";
    }

    @Override
    public String getCopyright() {
        return "© Faktor Zehn " + Year.now();
    }
}