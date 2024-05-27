import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HaveUnderscore{
    public boolean check(String password) {
        String upperRequirement = "(?=.*_)";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
