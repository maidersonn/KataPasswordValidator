import security.Result;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private int length;
    private boolean uppercase;
    private boolean lowercase;
    private boolean number;
    private boolean underscore;
    private PasswordValidatorStrategy strategy;

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

    public Result<Boolean, List<String>> doSomething(String password) {
        return strategy.execute(password, this);
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

    public void setStrategy(PasswordValidatorStrategy strategy) {
        this.strategy = strategy;
    }
}
