package Bai4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordServiceTest {

    private PasswordService service;

    @BeforeEach
    void setUp() {
        service = new PasswordService();
    }

    @Test
    void testPasswordStrengthLevels() {

        assertAll(

                () -> assertEquals("Mạnh",
                        service.evaluatePasswordStrength("Abc123!@")),

                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("abc123!@")),

                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("ABC123!@")),

                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("Abcdef!@")),

                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("Abc12345")),

                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("Ab1!")),

                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("password")),

                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("ABC12345"))
        );
    }
}
