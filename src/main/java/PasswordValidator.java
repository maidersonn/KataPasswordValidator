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
        Pattern pattern;
        Matcher matcher;
        if(this.length() >= password.length()) {
            if(this.isUppercase()) {
                String upperRequirement = "(?=.*[A-Z])";
                pattern = Pattern.compile(upperRequirement);
                matcher = pattern.matcher(password);
                if(!matcher.find())return false;
            }
        }
        return false;
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
