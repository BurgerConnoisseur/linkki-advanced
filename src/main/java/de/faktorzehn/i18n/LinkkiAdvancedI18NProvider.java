package de.faktorzehn.i18n;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.vaadin.flow.i18n.I18NProvider;

@Component
public class LinkkiAdvancedI18NProvider implements I18NProvider {
    @Override
    public List<Locale> getProvidedLocales() {
        return List.of(Locale.ENGLISH, Locale.GERMAN);
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        throw new UnsupportedOperationException("This kind of localization is not intended");
    }
}
