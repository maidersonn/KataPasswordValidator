import org.testng.annotations.Test;

import static junit.framework.Assert.*;

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
        String validPassword = "Aa413456_";
        PasswordBuider builder = new PasswordBuider();
        builder.withLowercase(true);
        builder.withLength(6);
        builder.withNumber(true);
        builder.withUppercase(true);
        builder.withUnderscore(true);
        PasswordValidator passwordValidator = builder.generate();
        PasswordValidatorStrategy stategy = new PasswordValidatorStrategy();
        passwordValidator.setStrategy(stategy);
        assertTrue(passwordValidator.doSomething(validPassword).isSuccess());
    }
    //Iteration 4
    @Test
    void when_password_without_uppercase_return_true() {
        String password = "aaa123456__";
        PasswordBuider builder = new PasswordBuider();
        builder.withLowercase(true);
        builder.withLength(6);
        builder.withNumber(true);
        builder.withUppercase(true);
        builder.withUnderscore(true);
        PasswordValidator passwordValidator = builder.generate();

        PasswordValidatorStrategy stategy = new PasswordValidatorStrategy();
        passwordValidator.setStrategy(stategy);

        assertTrue(passwordValidator.doSomething(password).isSuccess());
    }

    @Test
    void when_password_without_uppercase_and_without_underscore_return_errorList() {
        String password = "aaa12345698";
        PasswordBuider builder = new PasswordBuider();
        builder.withLowercase(true);
        builder.withLength(6);
        builder.withNumber(true);
        builder.withUppercase(true);
        builder.withUnderscore(true);
        PasswordValidator passwordValidator = builder.generate();

        PasswordValidatorStrategy stategy = new PasswordValidatorStrategy();
        passwordValidator.setStrategy(stategy);

        assertFalse(passwordValidator.doSomething(password).isSuccess());
        assertEquals(2, passwordValidator.doSomething(password).getError().size());
        assertEquals("No contiene mayúscula", passwordValidator.doSomething(password).getError().get(0));
        assertEquals("No contiene barra baja", passwordValidator.doSomething(password).getError().get(1));
    }
}
