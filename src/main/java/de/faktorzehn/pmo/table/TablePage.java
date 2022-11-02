package de.faktorzehn.pmo.table;

import java.util.List;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.vaadin.component.page.AbstractPage;

import de.faktorzehn.model.Person;

public class TablePage extends AbstractPage {

    private static final long serialVersionUID = 1L;

    private final BindingManager bindingManager = new DefaultBindingManager();

    public TablePage() {
    }

    @Override
    public void createContent() {
        var person = new Person();
        addSection(new PersonTablePmo(() -> List.of(person)));
        addSection(new EmptyNoPlaceholderPersonTablePmo());
        addSection(new EmptyWithPlaceholderPersonTablePmo());
        addSection(new PersonTableWithButton(() -> List.of(person)));
    }

    @Override
    protected BindingManager getBindingManager() {
        return bindingManager;
    }

}
