package de.faktorzehn.pmo.table.tree;


import de.faktorzehn.model.Address;
import de.faktorzehn.pmo.section.doublecolumn.DoubleColumnAddressSectionPmo;
import de.faktorzehn.pmo.section.singlecolumn.AddressSectionPmo;

public class GroupPersonAddressRowPmo extends AbstractGroupRowPmo {

    private final Address address;

    public GroupPersonAddressRowPmo(Address address) {
        this.address = address;
    }

    @Override
    public Object getAddress() {
        return new AddressSectionPmo(address);
    }

}
