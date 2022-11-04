package de.faktorzehn.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Person {

    public static final String PROPERTY_GIVEN_NAME = "givenName";
    public static final String PROPERTY_SURNAME = "surname";
    public static final String PROPERTY_DATE_OF_BIRTH = "dateOfBirth";
    public static final String PROPERTY_OCCUPATION = "occupation";
    public static final String ASSOCIATION_ADDRESSES = "addresses";

    public String givenName;
    public String surname;
    public LocalDate dateOfBirth;
    public String occupation;
    public List<Address> addresses;

    public Person() {
    }

    public Person(String givenName, String surname, LocalDate dateOfBirth, String occupation) {
        this.givenName = givenName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Person person = (Person)o;

        if (!Objects.equals(givenName, person.givenName))
            return false;
        if (!Objects.equals(surname, person.surname))
            return false;
        if (!Objects.equals(dateOfBirth, person.dateOfBirth))
            return false;
        if (!Objects.equals(occupation, person.occupation))
            return false;
        return Objects.equals(addresses, person.addresses);
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (addresses != null ? addresses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", occupation='" + occupation + '\'' +
                ", addresses=" + addresses +
                '}';
    }

}
