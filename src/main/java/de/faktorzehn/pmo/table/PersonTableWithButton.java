package de.faktorzehn.pmo.table;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.linkki.core.pmo.ButtonPmo;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.core.ui.pmo.ButtonPmoBuilder;
import org.linkki.framework.ui.dialogs.ConfirmationDialog;
import org.linkki.util.handler.Handler;

import com.vaadin.flow.component.icon.VaadinIcon;

import de.faktorzehn.model.Person;

@UISection(caption = "PersonTableWithButton")
public class PersonTableWithButton extends PersonTablePmo {
    public PersonTableWithButton(Supplier<List<? extends Person>> modelObjectsSupplier) {
        super(modelObjectsSupplier);
    }

    @Override
    public Optional<ButtonPmo> getAddItemButtonPmo() {
        return Optional.of(
                ButtonPmoBuilder
                        .action(() -> new ConfirmationDialog("Search", Handler.NOP_HANDLER).open())
                        .icon(VaadinIcon.SEARCH.create())
                        .get()
        );
    }
}
