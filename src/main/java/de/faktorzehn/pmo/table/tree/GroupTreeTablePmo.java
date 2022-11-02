package de.faktorzehn.pmo.table.tree;

import java.util.List;
import java.util.function.Supplier;

import org.linkki.core.defaults.columnbased.pmo.SimpleTablePmo;
import org.linkki.core.ui.layout.annotation.UISection;

import de.faktorzehn.model.Group;

@UISection(caption = "GroupTreeTablePmo")
public class GroupTreeTablePmo extends SimpleTablePmo<Group, AbstractGroupRowPmo> {

    public GroupTreeTablePmo(Supplier<List<? extends Group>> modelObjectsSupplier) {
        super(modelObjectsSupplier);
    }

    @Override
    protected AbstractGroupRowPmo createRow(Group modelObject) {
        return new GroupRowPmo(modelObject);
    }

    @Override
    public boolean isHierarchical() {
        return true;
    }

}
