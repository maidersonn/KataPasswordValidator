import security.Failure;
import security.Result;
import security.Success;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidatorStrategy implements Strategy{
    HasLowercase hasLowercase = new HasLowercase();
    HasUppercase hasUppercase = new HasUppercase();
    HasNumber hasNumber = new HasNumber();
    HaveUnderscore hasUnderscore = new HaveUnderscore();
    @Override
    public Result<Boolean, List<String>> execute(String password, PasswordValidator passwordInstance) {
        ArrayList<String> errors = new ArrayList<>();

        if (password.length() < passwordInstance.length()) errors.add("Largo inválido");
        if (passwordInstance.hasUppercase() && !hasUppercase.check(password)) errors.add("No contiene mayúscula");
        if (passwordInstance.hasLowercase() && !hasLowercase.check(password)) errors.add("No contiene minúscula");
        if (passwordInstance.hasNumber() && !hasNumber.check(password)) errors.add("No contiene número");
        if (passwordInstance.hasUnderscore() && !hasUnderscore.check(password)) errors.add("No contiene barra baja");

        if (errors.size() <= 1) {
            return new Success<>(Boolean.TRUE);
        } else {
            return new Failure<>(errors);
        }
    }
}
