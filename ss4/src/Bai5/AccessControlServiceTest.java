package Bai5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccessControlServiceTest {

    private AccessControlService service;
    private User admin;
    private User moderator;
    private User user;

    @BeforeEach
    void setUp() {
        service = new AccessControlService();

        admin = new User(Role.ADMIN);
        moderator = new User(Role.MODERATOR);
        user = new User(Role.USER);
    }

    @AfterEach
    void tearDown() {
        admin = null;
        moderator = null;
        user = null;
    }

    // ===== ADMIN TEST =====

    @Test
    void adminCanDeleteUser() {
        boolean result = service.canPerformAction(admin, Action.DELETE_USER);
        assertTrue(result);
    }

    @Test
    void adminCanLockUser() {
        boolean result = service.canPerformAction(admin, Action.LOCK_USER);
        assertTrue(result);
    }

    @Test
    void adminCanViewProfile() {
        boolean result = service.canPerformAction(admin, Action.VIEW_PROFILE);
        assertTrue(result);
    }

    // ===== MODERATOR TEST =====

    @Test
    void moderatorCannotDeleteUser() {
        boolean result = service.canPerformAction(moderator, Action.DELETE_USER);
        assertFalse(result);
    }

    @Test
    void moderatorCanLockUser() {
        boolean result = service.canPerformAction(moderator, Action.LOCK_USER);
        assertTrue(result);
    }

    @Test
    void moderatorCanViewProfile() {
        boolean result = service.canPerformAction(moderator, Action.VIEW_PROFILE);
        assertTrue(result);
    }

    // ===== USER TEST =====

    @Test
    void userCannotDeleteUser() {
        boolean result = service.canPerformAction(user, Action.DELETE_USER);
        assertFalse(result);
    }

    @Test
    void userCannotLockUser() {
        boolean result = service.canPerformAction(user, Action.LOCK_USER);
        assertFalse(result);
    }

    @Test
    void userCanViewProfile() {
        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);
        assertTrue(result);
    }
}
