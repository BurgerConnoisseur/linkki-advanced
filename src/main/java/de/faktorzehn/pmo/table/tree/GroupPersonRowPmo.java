package de.faktorzehn.pmo.table.tree;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.List;

import org.linkki.core.defaults.columnbased.pmo.HierarchicalRowPmo;
import org.linkki.core.pmo.ModelObject;

import de.faktorzehn.model.Person;

public class GroupPersonRowPmo extends AbstractGroupRowPmo implements HierarchicalRowPmo<GroupPersonAddressRowPmo> {


    @ModelObject
    private final Person person;
    private final List<? extends GroupPersonAddressRowPmo> addressRows;

    public GroupPersonRowPmo(Person person) {
        this.person = person;
        this.addressRows = person.getAddresses().stream()
                .map(GroupPersonAddressRowPmo::new)
                .collect(toList());
    }

    @Override
    public List<? extends GroupPersonAddressRowPmo> getChildRows() {
        return addressRows;
    }

    @Override
    public String getGivenName() {
        return person.getGivenName();
    }

    public void setGivenName(String givenName) {
        person.setGivenName(givenName);
    }

    @Override
    public String getSurname() {
        return person.getSurname();
    }

    public void setSurname(String surname) {
        person.setSurname(surname);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return person.getDateOfBirth();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        person.setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getOccupation() {
        return person.getOccupation();
    }

    public void setOccupation(String occupation) {
        person.setOccupation(occupation);
    }

}
