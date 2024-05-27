import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasLowercase {
    public boolean check(String password) {
        String upperRequirement = "(?=.*[a-z])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
