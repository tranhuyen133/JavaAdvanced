package Bai5;

public class AccessControlService {

    public boolean canPerformAction(User user, Action action) {

        Role role = user.getRole();

        switch (role) {

            case ADMIN:
                return true; // ADMIN làm được mọi action

            case MODERATOR:
                return action == Action.LOCK_USER
                        || action == Action.VIEW_PROFILE;

            case USER:
                return action == Action.VIEW_PROFILE;

            default:
                return false;
        }
    }
}
