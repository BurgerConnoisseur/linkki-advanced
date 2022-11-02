package de.faktorzehn.pmo.section.singlecolumn;

import java.time.LocalDate;

import org.linkki.core.pmo.ModelObject;
import org.linkki.core.ui.element.annotation.UIDateField;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;

import de.faktorzehn.model.Person;

@UISection(caption = "SampleSectionPmo")
public class PersonSectionPmo {

    @ModelObject
    private final Person person;

    public PersonSectionPmo(Person person) {
        this.person = person;
    }

    @UITextField(position = 10, label = "Given Name:", modelAttribute = Person.PROPERTY_GIVEN_NAME)
    public String getGivenName() {
        return person.getGivenName();
    }

    public void setGivenName(String givenName) {
        person.setGivenName(givenName);
    }

    @UITextField(position = 20, label = "Surname:", modelAttribute = Person.PROPERTY_SURNAME)
    public String getSurname() {
        return person.getSurname();
    }

    public void setSurname(String surname) {
        person.setSurname(surname);
    }

    @UIDateField(position = 30, label = "Date Of Birth:", modelAttribute = Person.PROPERTY_DATE_OF_BIRTH)
    public LocalDate getDateOfBirth() {
        return person.getDateOfBirth();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        person.setDateOfBirth(dateOfBirth);
    }

    @UITextField(position = 40, label = "Occupation:", modelAttribute = Person.PROPERTY_OCCUPATION)
    public String getOccupation() {
        return person.getOccupation();
    }

    public void setOccupation(String occupation) {
        person.setOccupation(occupation);
    }

}
