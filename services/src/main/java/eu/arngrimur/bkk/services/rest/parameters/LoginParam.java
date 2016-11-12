package eu.arngrimur.bkk.services.rest.parameters;


import eu.arngrimur.bkk.services.rest.validation.InputValidation;
import eu.arngrimur.utils.validation.ValidateString;

public class LoginParam  implements InputValidation {
    @ValidateString(regex = "[\\p{Lower}]{3,}")
    private String username;
    /**
     * Password must be at least 8 characters long, contain 1 lower case charecter, on upper case character,
     * one special character and no whitespace
     */
    @ValidateString(regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\p{Punct})(?=\\S+$).{8,}$")
    private String password;

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
}
