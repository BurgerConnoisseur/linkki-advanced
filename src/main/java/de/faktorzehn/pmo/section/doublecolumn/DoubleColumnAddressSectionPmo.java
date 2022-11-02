package de.faktorzehn.pmo.section.doublecolumn;

import org.linkki.core.pmo.ModelObject;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UIFormSection;

import de.faktorzehn.model.Address;

@UIFormSection(caption = "DoubleColumnAddressPmo", columns = 2)
public class DoubleColumnAddressSectionPmo {

    @ModelObject
    private final Address address;


    public DoubleColumnAddressSectionPmo(Address address) {
        this.address = address;
    }

    @UITextField(position = 10, label = "Street:", modelAttribute = Address.PROPERTY_STREET)
    public String getStreet() {
        return address.getStreet();
    }

    public void setStreet(String street) {
        address.setStreet(street);
    }

    @UITextField(position = 20, label = "Street Nr:", modelAttribute = Address.PROPERTY_STREET_NR)
    public String getStreetNr() {
        return address.getStreetNr();
    }

    public void setStreetNr(String streetNr) {
        address.setStreetNr(streetNr);
    }

    @UITextField(position = 30, label = "Post Office Box:", modelAttribute = Address.PROPERTY_POST_OFFICE_BOX)
    public String getPostOfficeBox() {
        return address.getPostOfficeBox();
    }

    public void setPostOfficeBox(String postOfficeBox) {
        address.setPostOfficeBox(postOfficeBox);
    }

    @UITextField(position = 40, label = "Additional Info:", modelAttribute = Address.PROPERTY_ADDITIONAL_INFO)
    public String getAdditionalInfo() {
        return address.getAdditionalInfo();
    }

    public void setAdditionalInfo(String additionalInfo) {
        address.setAdditionalInfo(additionalInfo);
    }

    @UITextField(position = 50, label = "Zip Code:", modelAttribute = Address.PROPERTY_ZIP_CODE)
    public String getZipCode() {
        return address.getZipCode();
    }

    public void setZipCode(String zipCode) {
        address.setZipCode(zipCode);
    }

    @UITextField(position = 60, label = "City:", modelAttribute = Address.PROPERTY_CITY)
    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    @UITextField(position = 70, label = "State:", modelAttribute = Address.PROPERTY_STATE)
    public String getState() {
        return address.getState();
    }

    public void setState(String state) {
        address.setState(state);
    }

    @UITextField(position = 80, label = "Country:", modelAttribute = Address.PROPERTY_COUNTRY)
    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

}
