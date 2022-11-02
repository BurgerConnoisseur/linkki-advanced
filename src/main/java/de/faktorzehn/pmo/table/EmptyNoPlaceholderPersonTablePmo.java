package de.faktorzehn.pmo.table;

import java.util.List;

import org.linkki.core.ui.layout.annotation.UISection;

@UISection(caption = "EmptyNoPlaceholderPersonTablePmo")
public class EmptyNoPlaceholderPersonTablePmo extends PersonTablePmo {

    public EmptyNoPlaceholderPersonTablePmo() {
        super(List::of);
    }
}
