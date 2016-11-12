package eu.arngrimur.bkk.services.rest.parameters;

import eu.arngrimur.bkk.services.rest.validation.InputValidation;
import eu.arngrimur.utils.validation.ValidateString;

public class UserParameters extends LoginParam implements InputValidation {

    @ValidateString(regex = "[\\p{Alpha}\\p{Space}]+")
    private String firstName;
    @ValidateString(regex = "[\\p{Alpha}\\p{Space}]+")
    private String lastName;
    @ValidateString(regex = "[\\p{Alpha}\\p{Space}]+")
    private String street;
    @ValidateString(regex = "[\\p{Digit}]+")
    String postbox;
    @ValidateString(regex = "[\\p{Alpha}\\p{Space}]+")
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostbox() {
        return postbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
