
import security.Failure;
import security.Result;
import security.Success;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private int length;
    private boolean uppercase;
    private boolean lowercase;
    private boolean number;
    private boolean underscore;

    public PasswordValidator(int length, boolean uppercase, boolean lowercase, boolean number, boolean underscore) {
        this.length = length;
        this.uppercase = uppercase;
        this.lowercase = lowercase;
        this.number = number;
        this.underscore = underscore;
    }

    public PasswordValidator() {
    }
    // iteracion 1
    public boolean isValid(String password) {
        String password_requirements = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*_)[0-9A-Za-z_]{8,}$";
        Pattern pattern = Pattern.compile(password_requirements);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    // iteracion 2
    public Result<Boolean, List<String>> isValidPassword(String password) {

        ArrayList<String> errors = new ArrayList<>();

        if (password.length() < this.length()) errors.add("Largo inválido");
        if (this.hasUppercase() && !hasUpperCase(password)) errors.add("No contiene mayúscula");
        if (this.hasLowercase() && !hasLowerCase(password)) errors.add("No contiene minúscula");
        if (this.hasNumber() && !hasNumber(password)) errors.add("No contiene número");
        if (this.hasUnderscore() && !hasUnderscore(password)) errors.add("No contiene barra baja");


    }

    private boolean hasUnderscore(String password) {
        String upperRequirement = "(?=.*_)";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find())return false;
        return true;
    }

    private boolean hasNumber(String password) {
        String upperRequirement = "(?=.*[0-9])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find())return false;
        return true;
    }

    private boolean hasLowerCase(String password) {
        String upperRequirement = "(?=.*[a-z])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find())return false;
        return true;
    }

    private boolean hasUpperCase(String password) {
        String upperRequirement = "(?=.*[A-Z])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find())return false;
        return true;
    }

    public int length() { return length; }
    public boolean hasUppercase() {
        return uppercase;
    }

    public boolean hasLowercase() {
        return lowercase;
    }

    public boolean hasNumber() {
        return number;
    }

    public boolean hasUnderscore() {
        return underscore;
    }

}
