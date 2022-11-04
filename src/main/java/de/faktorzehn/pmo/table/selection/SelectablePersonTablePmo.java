package de.faktorzehn.pmo.table.selection;

import java.util.List;
import java.util.function.Supplier;

import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.framework.ui.dialogs.ConfirmationDialog;
import org.linkki.framework.ui.notifications.NotificationUtil;
import org.linkki.util.handler.Handler;

import de.faktorzehn.model.Person;
import de.faktorzehn.pmo.table.PersonRowPmo;

@UISection(caption = "SelectablePersonTablePmo")
public class SelectablePersonTablePmo extends SelectableSimpleTablePmo<Person, PersonRowPmo> {

    public SelectablePersonTablePmo(
            Supplier<List<? extends Person>> modelObjectSupplier
    ) {
        super(
                SelectableSimpleTablePmoController.singleClick(SelectablePersonTablePmo::showNotification),
                modelObjectSupplier
        );
    }

    private static ConfirmationDialog confirmationDialog() {
        return new ConfirmationDialog("Double Click", Handler.NOP_HANDLER);
    }

    private static void showNotification(PersonRowPmo rowPmo) {
        NotificationUtil.showInfo("Selection:", rowPmo.getPerson().toString());
    }

    @Override
    protected PersonRowPmo createRow(Person modelObject) {
        return new PersonRowPmo(modelObject);
    }
}
