import org.testng.annotations.Test;

import static junit.framework.Assert.*;

public class PasswordBuilderTest {
    @Test
    public void itCreatesPasswordWithProperties () {
        PasswordBuider builder = new PasswordBuider();
        builder.withLowercase(true);
        builder.withLength(5);
        builder.withNumber(true);
        builder.withUppercase(false);
        builder.withUnderscore(true);
        PasswordValidator passwordValidator = builder.generate();
        assertTrue(passwordValidator.isLowercase());
        assertEquals(5, passwordValidator.length());
        assertTrue(passwordValidator.isHaveNumber());
        assertFalse(passwordValidator.isUppercase());
        assertTrue(passwordValidator.isHaveUnderscore());
    }
}
