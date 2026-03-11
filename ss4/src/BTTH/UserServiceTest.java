package BTTH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    // Test Case 1
    @Test
    void shouldAddUserSuccessfully() {

        // Arrange
        User user = new User(1, "john", "john@gmail.com");

        // Act
        userService.addUser(user);

        // Assert
        assertEquals(1, userService.getUserCount());
    }

    // Test Case 2
    @Test
    void shouldThrowExceptionWhenUsernameIsNull() {

        // Arrange
        User user = new User(2, null, "test@gmail.com");

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(user);
        });
    }

    // Test Case 3
    @Test
    void shouldReturnNullWhenUserNotFound() {

        // Arrange
        User user = new User(1, "john", "john@gmail.com");
        userService.addUser(user);

        // Act
        User result = userService.findUserById(2);

        // Assert
        assertNull(result);
    }

    // Test Case 4
    @Test
    void shouldReturnTrueWhenEmailIsValid() {

        // Arrange
        String email = "user@gmail.com";

        // Act
        boolean result = userService.isValidEmail(email);

        // Assert
        assertTrue(result);
    }
}
