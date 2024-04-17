import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    int length;
    boolean uppercase;
    boolean lowercase;
    boolean haveNumber;
    boolean haveUnderscore;
    String content;

    public Password(int length, boolean uppercase, boolean lowercase, boolean haveNumber, boolean haveUnderscore) {
        this.length = length;
        this.uppercase = uppercase;
        this.lowercase = lowercase;
        this.haveNumber = haveNumber;
        this.haveUnderscore = haveUnderscore;
    }

    public boolean isValid(String password) {
        String password_requirements = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*_)[0-9A-Za-z_]{8,}$";
        Pattern pattern = Pattern.compile(password_requirements);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
