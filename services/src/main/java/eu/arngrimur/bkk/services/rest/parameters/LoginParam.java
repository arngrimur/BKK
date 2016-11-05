package eu.arngrimur.bkk.services.rest.parameters;


import eu.arngrimur.bkk.services.rest.validation.InputValidation;
import eu.arngrimur.bkk.services.rest.validation.ValidateString;

public final class LoginParam  implements InputValidation {
    private String username;
    private String password;

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
}
