package de.faktorzehn.ui;

import org.linkki.framework.ui.application.ApplicationConfig;
import org.linkki.framework.ui.application.menu.ApplicationMenuItemDefinition;
import org.linkki.util.Sequence;

public class LinkkiAdvancedConfig implements ApplicationConfig {

    @Override
    public LinkkiAdvancedInfo getApplicationInfo() {
        return new LinkkiAdvancedInfo();
    }

    @Override
    public Sequence<ApplicationMenuItemDefinition> getMenuItemDefinitions() {
        return Sequence.empty();
    }

}