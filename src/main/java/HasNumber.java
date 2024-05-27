import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasNumber{
    public boolean check(String password) {
        String upperRequirement = "(?=.*[0-9])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
