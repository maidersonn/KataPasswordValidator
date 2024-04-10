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
        assertTrue(password.is_valid(valid_password));
        assertFalse(password.is_valid(invalid_password));
    }
}
