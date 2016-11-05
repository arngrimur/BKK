package eu.arngrimur.bkk.services.rest.parameters;

import eu.arngrimur.bkk.services.rest.validation.InputValidation;
import eu.arngrimur.bkk.services.rest.validation.ValidateNumber;
import eu.arngrimur.bkk.services.rest.validation.ValidateString;

public class UserParameters implements InputValidation {
    String username;
    String password;
    String firstName;
    String lastName;
    String street;
    String postbox;
    String city;

    @ValidateString
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ValidateString
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @ValidateString
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @ValidateString
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @ValidateString
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @ValidateString
    public String getPostbox() {
        return postbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }
    @ValidateString
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
