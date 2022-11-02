package de.faktorzehn.pmo.table;

import java.util.List;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.vaadin.component.page.AbstractPage;

import de.faktorzehn.model.Address;
import de.faktorzehn.model.Group;
import de.faktorzehn.model.Person;
import de.faktorzehn.pmo.table.tree.GroupTreeTablePmo;

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

        var group = new Group();
        group.setName("G1");
        group.setPeople(List.of(
                withAddress(new Person()),
                withAddress(new Person()),
                withAddress(new Person())
        ));

        var group2 = new Group();
        group2.setName("G2");
        group2.setPeople(List.of(withAddress(new Person())));
        addSection(new GroupTreeTablePmo(() -> List.of(group, group2)));
    }

    @Override
    protected BindingManager getBindingManager() {
        return bindingManager;
    }

    private Person withAddress(Person person) {
        if (person.getAddresses() == null || person.getAddresses().isEmpty()) {
            person.setAddresses(List.of(new Address()));
        }

        return person;
    }

}
