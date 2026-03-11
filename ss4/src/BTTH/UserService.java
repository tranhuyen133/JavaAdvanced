package BTTH;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    // thêm user
    public void addUser(User user) {

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        users.add(user);
    }

    // tìm user theo id
    public User findUserById(int id) {

        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    // kiểm tra email
    public boolean isValidEmail(String email) {

        if (email == null || email.isEmpty()) {
            return false;
        }

        return email.contains("@");
    }

    // dùng cho test kiểm tra size
    public int getUserCount() {
        return users.size();
    }
}
