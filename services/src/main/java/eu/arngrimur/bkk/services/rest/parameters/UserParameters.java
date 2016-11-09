package eu.arngrimur.bkk.services.rest.parameters;

import eu.arngrimur.bkk.services.rest.validation.InputValidation;
import eu.arngrimur.bkk.services.rest.validation.ValidateString;

public class UserParameters implements InputValidation {
    @ValidateString(regex = "[\\p{Lower}]{3,}")
    private String username;
    /**
     * Password must be at least 8 characters long, contain 1 lower case charecter, on upper case character,
     * one special character and no whitespace
     */
    @ValidateString(regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\p{Punct})(?=\\S+$).{8,}$")
    private String password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
