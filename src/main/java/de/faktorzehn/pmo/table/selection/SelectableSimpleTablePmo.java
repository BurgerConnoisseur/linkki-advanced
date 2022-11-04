package de.faktorzehn.pmo.table.selection;

import java.util.List;
import java.util.function.Supplier;

import org.linkki.core.defaults.columnbased.pmo.SimpleTablePmo;
import org.linkki.core.ui.table.pmo.SelectableTablePmo;

public abstract class SelectableSimpleTablePmo<MO, ROW> extends SimpleTablePmo<MO, ROW>
        implements SelectableTablePmo<ROW> {

    private final SelectableSimpleTablePmoController<MO, ROW> controller;

    public SelectableSimpleTablePmo(SelectableSimpleTablePmoController<MO, ROW> controller,
                                    Supplier<List<? extends MO>> modelObjectSupplier) {
        super(modelObjectSupplier);
        this.controller = controller;
    }

    @Override
    public ROW getSelection() {
        return controller.getSelection().orElse(null);
    }

    @Override
    public void setSelection(ROW selectedRow) {
        controller.setSelection(selectedRow);
        controller.onClick(selectedRow);
    }

    @Override
    public void onDoubleClick() {
        controller.getSelection().ifPresent(controller::onDoubleClick);
    }
}
