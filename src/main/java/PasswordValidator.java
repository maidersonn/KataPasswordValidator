import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private int length;
    private boolean uppercase;
    private boolean lowercase;
    private boolean haveNumber;
    private boolean haveUnderscore;

    public PasswordValidator(int length, boolean uppercase, boolean lowercase, boolean haveNumber, boolean haveUnderscore) {
        this.length = length;
        this.uppercase = uppercase;
        this.lowercase = lowercase;
        this.haveNumber = haveNumber;
        this.haveUnderscore = haveUnderscore;
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
    public boolean isOk(String password) {

        if(password.length() < this.length()) return false;
        if(this.isUppercase() && !haveUpperCase(password)) return false;
        if(this.isLowercase() && !haveLowerCase(password)) return false;
        if(this.isHaveNumber() && !haveNumber(password)) return false;
        if(this.isHaveUnderscore() && !haveUnderscore(password)) return false;
        return true;
    }

    private boolean haveUnderscore(String password) {
        String upperRequirement = "(?=.*_)";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find())return false;
        return true;
    }

    private boolean haveNumber(String password) {
        String upperRequirement = "(?=.*[0-9])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find())return false;
        return true;
    }

    private boolean haveLowerCase(String password) {
        String upperRequirement = "(?=.*[a-z])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find())return false;
        return true;
    }

    private boolean haveUpperCase(String password) {
        String upperRequirement = "(?=.*[A-Z])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find())return false;
        return true;
    }
    public int length() {
        return length;
    }

    public boolean isUppercase() {
        return uppercase;
    }

    public boolean isLowercase() {
        return lowercase;
    }

    public boolean isHaveNumber() {
        return haveNumber;
    }

    public boolean isHaveUnderscore() {
        return haveUnderscore;
    }
}
