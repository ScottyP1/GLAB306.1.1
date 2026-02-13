package junit.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordComplyTest {

    @Test
    void testDoesPasswordComply() {
        boolean expectedResult = true;
        junit.test.PasswordComply password = new junit.test.PasswordComply("abcd1234");
        boolean actualResult = password.doesPasswordComply();
        assertEquals(expectedResult,actualResult, "Password conditions failed!");
        System.out.println("Password conditions success!");
    }

    @Test
    void testDoesPasswordExist() {
        junit.test.PasswordComply password = new junit.test.PasswordComply("abcd1234");
        assertThrows(java.sql.SQLException.class,() -> password.doesNotAlreadyExist(), "SQL Exception was thrown.");
    }

    @Test
    void testEmptyPassword() {
        junit.test.PasswordComply password = new junit.test.PasswordComply("Abcd1234!");
        assertThrows(NullPointerException.class,() -> password.doesNotAlreadyExist(), "Null Exception was thrown but received SQL Exception.");
    }
}
