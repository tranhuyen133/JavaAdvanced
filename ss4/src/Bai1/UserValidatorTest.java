package Bai1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    @Test
    void TC01_validUsername() {

        // Arrange
        UserValidator validator = new UserValidator();
        String username = "user123";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertTrue(result);
    }

    @Test
    void TC02_usernameTooShort() {

        // Arrange
        UserValidator validator = new UserValidator();
        String username = "abc";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }

    @Test
    void TC03_usernameContainsSpace() {

        // Arrange
        UserValidator validator = new UserValidator();
        String username = "user name";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }
}
