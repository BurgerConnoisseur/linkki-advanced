package de.faktorzehn.pmo.layout;

import org.linkki.core.binding.BindingContext;
import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.ui.creation.VaadinUiCreator;
import org.linkki.core.vaadin.component.page.AbstractPage;

import de.faktorzehn.model.Person;

public class LayoutPage extends AbstractPage {

    private static final long serialVersionUID = 1L;

    private final BindingManager bindingManager = new DefaultBindingManager();

    public LayoutPage() {
    }

    @Override
    public void createContent() {
        var bindingContext = getBindingContext();

        add(VaadinUiCreator.createComponent(new HorizontalLayoutSectionPmo(new Person()), bindingContext));
        add(VaadinUiCreator.createComponent(new VerticalLayoutSectionPmo(new Person()), bindingContext));
        add(VaadinUiCreator.createComponent(new NestedSectionPmo(), bindingContext));
    }

    @Override
    protected BindingManager getBindingManager() {
        return bindingManager;
    }
}