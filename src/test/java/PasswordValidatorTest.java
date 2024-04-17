import org.testng.annotations.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class PasswordValidatorTest {
    // contrasena es valida o no
    /*
        Tener más de 8 caracteres
        Contener una letra mayúscula
        Contener una letra minúscula
        Contener un número
        Contener un guión bajo
    */

    @Test
    void is_password_valid () {
        String valid_password = "Aa345678_";
        String invalid_password = "kjfklds90fma";
        PasswordValidator password = new PasswordValidator();
        assertTrue(password.isValid(valid_password));
        assertFalse(password.isValid(invalid_password));
    }

    @Test
    void this_password_not_contain_numbers () {
        String notValidPassword = "aaaAA_bvVbfc";
        PasswordValidator password = new PasswordValidator();
        assertFalse(password.isValid(notValidPassword));
    }

    @Test
    void this_password_not_contain_lowercase () {
        String notValidPassword = "AAAAAAA576385_";
        PasswordValidator password = new PasswordValidator();
        assertFalse(password.isValid(notValidPassword));
    }

    @Test
    void this_password_not_contain_uppercase () {
        String notValidPassword = "aaaaaa65747437___";
        PasswordValidator password = new PasswordValidator();
        assertFalse(password.isValid(notValidPassword));
    }

    @Test
    void this_password_not_contain_underscore () {
        String notValidPassword = "frtggEWVEWRG3453434";
        PasswordValidator password = new PasswordValidator();
        assertFalse(password.isValid(notValidPassword));
    }
    //ITERACION 2
    @Test
    void this_password_pass_requirements () {
        String validPassword = "Aa13456";
        PasswordBuider builder = new PasswordBuider();
        builder.withLowercase(true);
        builder.withLength(6);
        builder.withNumber(true);
        builder.withUppercase(true);
        builder.withUnderscore(false);
        PasswordValidator passwordValidator = builder.generate();
        assertTrue(passwordValidator.isOk(validPassword));
    }
}
