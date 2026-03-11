package Bai2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void testAge18_validRegistration() {

        // Arrange
        UserService service = new UserService();
        int age = 18;

        // Act
        boolean result = service.checkRegistrationAge(age);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void testAge17_invalidRegistration() {

        // Arrange
        UserService service = new UserService();
        int age = 17;

        // Act
        boolean result = service.checkRegistrationAge(age);

        // Assert
        assertEquals(false, result);
    }

    @Test
    void testNegativeAge_throwException() {

        // Arrange
        UserService service = new UserService();

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(-1);
        });
    }
}
