package de.faktorzehn.model;

import java.util.Objects;

public class Address {

    public static final String PROPERTY_STREET = "street";
    public static final String PROPERTY_STREET_NR = "streetNr";
    public static final String PROPERTY_POST_OFFICE_BOX = "postOfficeBox";
    public static final String PROPERTY_ADDITIONAL_INFO = "additionalInfo";
    public static final String PROPERTY_ZIP_CODE = "zipCode";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_STATE = "state";
    public static final String PROPERTY_COUNTRY = "country";

    private String street;
    private String streetNr;
    private String postOfficeBox;
    private String additionalInfo;
    private String zipCode;
    private String city;
    private String state;
    private String country;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getPostOfficeBox() {
        return postOfficeBox;
    }

    public void setPostOfficeBox(String postOfficeBox) {
        this.postOfficeBox = postOfficeBox;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Address address = (Address)o;

        if (!Objects.equals(street, address.street))
            return false;
        if (!Objects.equals(streetNr, address.streetNr))
            return false;
        if (!Objects.equals(postOfficeBox, address.postOfficeBox))
            return false;
        if (!Objects.equals(additionalInfo, address.additionalInfo))
            return false;
        if (!Objects.equals(zipCode, address.zipCode))
            return false;
        if (!Objects.equals(city, address.city))
            return false;
        if (!Objects.equals(state, address.state))
            return false;
        return Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (streetNr != null ? streetNr.hashCode() : 0);
        result = 31 * result + (postOfficeBox != null ? postOfficeBox.hashCode() : 0);
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streetNr='" + streetNr + '\'' +
                ", postOfficeBox='" + postOfficeBox + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
