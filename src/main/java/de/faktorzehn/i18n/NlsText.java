package de.faktorzehn.i18n;

import static java.util.Objects.requireNonNull;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class NlsText {

    private final String baseName;
    private final Locale locale;

    public NlsText(String baseName, Locale locale) {
        this.baseName = baseName;
        this.locale = locale;
    }

    public String get(String key) {
        try {
            return getResourceBundle().getString(requireNonNull(key, "key must be not null"));
        } catch (MissingResourceException ex) {
            return '!' + key + '!';
        }
    }

    private ResourceBundle getResourceBundle() {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        Locale bundleLocale = bundle.getLocale();
        if (!bundleLocale.equals(locale) && !locale.equals(Locale.getDefault())
                && !bundleLocale.getLanguage().equals(locale.getLanguage())) {
            bundle = ResourceBundle.getBundle(baseName, Locale.ROOT);
        }
        return bundle;
    }

}
