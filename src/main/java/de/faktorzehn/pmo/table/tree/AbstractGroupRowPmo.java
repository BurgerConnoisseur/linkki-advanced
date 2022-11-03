package de.faktorzehn.pmo.table.tree;

import java.time.LocalDate;

import org.linkki.core.ui.aspects.annotation.BindVisible;
import org.linkki.core.ui.element.annotation.UIDateField;
import org.linkki.core.ui.element.annotation.UILabel;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.core.ui.nested.annotation.UINestedComponent;
import org.linkki.core.ui.table.column.annotation.UITableColumn;

import de.faktorzehn.model.Person;

public abstract class AbstractGroupRowPmo {

    @UITableColumn(flexGrow = 0)
    @UILabel(position = 0, label = "Group")
    public String getGroup() {
        return "";
    }

    @BindVisible
    @UITableColumn(flexGrow = 1)
    @UITextField(position = 10, label = "Given Name", modelAttribute = Person.PROPERTY_GIVEN_NAME)
    public String getGivenName() {
        return "";
    }

    public boolean isGivenNameVisible() {
        return this instanceof GroupPersonRowPmo;
    }


    @BindVisible
    @UITableColumn(flexGrow = 1)
    @UITextField(position = 20, label = "Surname", modelAttribute = Person.PROPERTY_SURNAME)
    public String getSurname() {
        return "";
    }

    public boolean isSurnameVisible() {
        return this instanceof GroupPersonRowPmo;
    }

    @BindVisible
    @UITableColumn(flexGrow = 1)
    @UIDateField(position = 30, label = "Date Of Birth", modelAttribute = Person.PROPERTY_DATE_OF_BIRTH)
    public LocalDate getDateOfBirth() {
        return null;
    }

    public boolean isDateOfBirthVisible() {
        return this instanceof GroupPersonRowPmo;
    }
    @BindVisible
    @UITableColumn(flexGrow = 1)
    @UITextField(position = 40, label = "Occupation", modelAttribute = Person.PROPERTY_OCCUPATION)
    public String getOccupation() {
        return "";
    }

    public boolean isOccupationVisible() {
        return this instanceof GroupPersonRowPmo;
    }
    @BindVisible
    @UITableColumn(flexGrow = 3, collapsible = UITableColumn.CollapseMode.COLLAPSIBLE)
    @UINestedComponent(position = 50, label = "Address")
    public Object getAddress() {

        @UISection
        class EmptyPmo {}

        return new EmptyPmo();
    }

    public boolean isAddressVisible() {
        return this instanceof GroupPersonAddressRowPmo;
    }
}
