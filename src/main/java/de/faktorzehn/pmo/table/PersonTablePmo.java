package de.faktorzehn.pmo.table;


import java.util.List;
import java.util.function.Supplier;

import org.linkki.core.defaults.columnbased.pmo.SimpleTablePmo;
import org.linkki.core.ui.layout.annotation.UISection;

import de.faktorzehn.model.Person;

@UISection(caption = "PersonTablePmo")
public class PersonTablePmo extends SimpleTablePmo<Person, PersonRowPmo> {

    public PersonTablePmo(Supplier<List<? extends Person>> modelObjectsSupplier) {
        super(modelObjectsSupplier);
    }

    @Override
    protected PersonRowPmo createRow(Person modelObject) {
        return new PersonRowPmo(modelObject);
    }
}
