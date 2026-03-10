package Bai3;

import java.util.*;

public class UserRepository {

    List<User> users = List.of(
            new User("alice", "alice@gmail.com", "ACTIVE"),
            new User("bob", "bob@yahoo.com", "INACTIVE"),
            new User("charlie", "charlie@gmail.com", "ACTIVE")
    );

    public Optional<User> findUserByUsername(String username) {

        return users.stream()
                .filter(user -> user.username().equals(username))
                .findFirst();
    }
}
