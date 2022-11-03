package de.faktorzehn.pmo.table;

import java.util.List;

import org.linkki.core.ui.aspects.annotation.BindPlaceholder;
import org.linkki.core.ui.layout.annotation.UISection;

@BindPlaceholder("There are no people available.")
@UISection(caption = "EmptyWithPlaceholderPersonTablePmo")
public class EmptyWithPlaceholderPersonTablePmo extends PersonTablePmo {
    public EmptyWithPlaceholderPersonTablePmo() {
        super(List::of);
    }
}
