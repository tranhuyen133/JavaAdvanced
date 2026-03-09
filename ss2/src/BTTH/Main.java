package BTTH;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        UserManagement manager = new UserManagement();

        User newUser = manager.createUser.get();
        System.out.println("Created user: " + newUser);

        String username = "huyennn";

        boolean valid = IUserAccount.isStandardLength(username);
        System.out.println("Username valid: " + valid);

        User u1 = new User("huyen123", "huyen@gmail.com", "ADMIN", "ACTIVE");

        String email = manager.getEmail.apply(u1);
        System.out.println("Email: " + email);

        List<User> users = new ArrayList<>();

        users.add(u1);
        users.add(new User("linh123", "linh@gmail.com", "USER", "ACTIVE"));
        users.add(new User("anh123", "anh@gmail.com", "USER", "INACTIVE"));
        users.add(new User("nam123", "nam@gmail.com", "ADMIN", "ACTIVE"));

        users.forEach(System.out::println);
    }
}
