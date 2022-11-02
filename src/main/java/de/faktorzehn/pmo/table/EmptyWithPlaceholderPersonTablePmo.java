package de.faktorzehn.pmo.table;

import java.util.List;
import java.util.function.Supplier;

import org.linkki.core.ui.aspects.annotation.BindPlaceholder;
import org.linkki.core.ui.layout.annotation.UISection;

import de.faktorzehn.model.Person;

@BindPlaceholder("There are no people available.")
@UISection(caption = "EmptyWithPlaceholderPersonTablePmo")
public class EmptyWithPlaceholderPersonTablePmo extends PersonTablePmo {
    public EmptyWithPlaceholderPersonTablePmo() {
        super(List::of);
    }
}
