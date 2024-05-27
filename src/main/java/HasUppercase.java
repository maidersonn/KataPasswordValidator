import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasUppercase{
    public boolean check(String password) {
        String upperRequirement = "(?=.*[A-Z])";
        Pattern pattern = Pattern.compile(upperRequirement);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
