package de.faktorzehn.pmo.table.selection;

import java.util.Optional;

public interface SelectableSimpleTablePmoController<MO, ROW> {

    Optional<ROW> getSelection();

    void setSelection(ROW selection);

    void onClick(ROW rowPmo);

    void onDoubleClick(ROW rowPmo);

    static <MO, ROW> SelectableSimpleTablePmoController<MO, ROW> singleClick(SelectionHandler<ROW> onClick) {
        return new DefaultSelectableSimpleTablePmoController<>(onClick, SelectionHandler.nop());
    }

    static <MO, ROW> SelectableSimpleTablePmoController<MO, ROW> doubleClick(SelectionHandler<ROW> onDoubleClick) {
        return new DefaultSelectableSimpleTablePmoController<>(SelectionHandler.nop(), onDoubleClick);
    }

    static <MO, ROW> SelectableSimpleTablePmoController<MO, ROW> simple() {
        return new DefaultSelectableSimpleTablePmoController<>(
                SelectionHandler.nop(),
                SelectionHandler.nop()
        );
    }
}

@FunctionalInterface
interface SelectionHandler<ROW> {
    SelectionHandler<?> NOP_HANDLER = (row) -> {
    };

    void handle(ROW row);

    @SuppressWarnings("unchecked")
    static <MO, ROW> SelectionHandler<ROW> nop() {
        return (SelectionHandler<ROW>)NOP_HANDLER;
    }
}

class DefaultSelectableSimpleTablePmoController<MO, ROW> implements SelectableSimpleTablePmoController<MO, ROW> {

    private final SelectionHandler<ROW> onClick;
    private final SelectionHandler<ROW> onDoubleClick;
    private ROW selection = null;

    public DefaultSelectableSimpleTablePmoController(
            SelectionHandler<ROW> onClick,
            SelectionHandler<ROW> onDoubleClick
    ) {
        this.onClick = onClick;
        this.onDoubleClick = onDoubleClick;
    }

    @Override
    public Optional<ROW> getSelection() {
        return Optional.ofNullable(selection);
    }

    public void setSelection(ROW selection) {
        this.selection = selection;
    }

    @Override
    public void onClick(ROW rowPmo) {
        onClick.handle(rowPmo);
    }

    @Override
    public void onDoubleClick(ROW rowPmo) {
        onDoubleClick.handle(rowPmo);
    }
}
