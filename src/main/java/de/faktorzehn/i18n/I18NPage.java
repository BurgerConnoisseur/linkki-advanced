package de.faktorzehn.i18n;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.vaadin.component.page.AbstractPage;

import de.faktorzehn.model.Person;


public class I18NPage extends AbstractPage {

    private final DefaultBindingManager defaultBindingManager = new DefaultBindingManager();

    @Override
    protected BindingManager getBindingManager() {
        return defaultBindingManager;
    }

    @Override
    public void createContent() {
        addSection(new I18NPersonSectionPmo(new Person()));
        addSection(new ChildI18NPersonSectionPmo(new Person()));
    }
}
