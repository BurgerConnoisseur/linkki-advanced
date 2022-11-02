package de.faktorzehn.pmo.table.tree;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.linkki.core.defaults.columnbased.pmo.HierarchicalRowPmo;

import de.faktorzehn.model.Group;

public class GroupRowPmo extends AbstractGroupRowPmo implements HierarchicalRowPmo<GroupPersonRowPmo> {

    private final Group group;
    private final List<? extends GroupPersonRowPmo> personRows;

    public GroupRowPmo(Group group) {
        this.group = group;
        this.personRows = group.getPeople().stream()
                .map(GroupPersonRowPmo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<? extends GroupPersonRowPmo> getChildRows() {
        return personRows;
    }

    @Override
    public String getGroup() {
        return group.getName();
    }

}
