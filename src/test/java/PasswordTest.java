import org.testng.annotations.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class PasswordTest {
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
        Password password = new Password();
        assertTrue(password.isValid(valid_password));
        assertFalse(password.isValid(invalid_password));
    }

    @Test
    void this_password_not_contain_numbers () {
        String notValidPassword = "aaaAA_bvVbfc";
        Password password = new Password();
        assertFalse(password.isValid(notValidPassword));
    }

    @Test
    void this_password_not_contain_lowercase () {
        String notValidPassword = "AAAAAAA576385_";
        Password password = new Password();
        assertFalse(password.isValid(notValidPassword));
    }

    @Test
    void this_password_not_contain_uppercase () {
        String notValidPassword = "aaaaaa65747437___";
        Password password = new Password();
        assertFalse(password.isValid(notValidPassword));
    }

    @Test
    void this_password_not_contain_underscore () {
        String notValidPassword = "frtggEWVEWRG3453434";
        Password password = new Password();
        assertFalse(password.isValid(notValidPassword));
    }
}
