package de.faktorzehn.i18n;

import java.time.LocalDate;

import org.linkki.core.pmo.ModelObject;
import org.linkki.core.ui.element.annotation.UIDateField;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.core.uiframework.UiFramework;

import de.faktorzehn.annotation.label.BindLabel;
import de.faktorzehn.model.Person;

@UISection(caption = "I18NPersonSectionPmo")
public class I18NPersonSectionPmo {

    @ModelObject
    private final Person person;

    private final NlsText nlsText = new NlsText(
            I18NPersonSectionPmo.class.getPackageName() + ".linkki-messages",
            UiFramework.getLocale()
    );

    public I18NPersonSectionPmo(Person person) {
        this.person = person;
    }

    @UITextField(position = 10, modelAttribute = Person.PROPERTY_GIVEN_NAME)
    public String getGivenName() {
        return person.getGivenName();
    }

    public void setGivenName(String givenName) {
        person.setGivenName(givenName);
    }

    @UITextField(position = 20, modelAttribute = Person.PROPERTY_SURNAME)
    public String getSurname() {
        return person.getSurname();
    }

    public void setSurname(String surname) {
        person.setSurname(surname);
    }

    @UIDateField(position = 30, modelAttribute = Person.PROPERTY_DATE_OF_BIRTH)
    public LocalDate getDateOfBirth() {
        return person.getDateOfBirth();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        person.setDateOfBirth(dateOfBirth);
    }

    @BindLabel
    @UITextField(position = 40, modelAttribute = Person.PROPERTY_OCCUPATION)
    public String getOccupation() {
        return person.getOccupation();
    }

    public void setOccupation(String occupation) {
        person.setOccupation(occupation);
    }

    public String getOccupationLabel() {
        return nlsText.get("custom_I18NPersonSectionPmo_occupation_label");
    }

}
