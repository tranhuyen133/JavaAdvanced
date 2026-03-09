package Bai4;

import java.util.*;
import java.util.function.*;

class User {
    private String username;

    public User() {
        this.username = "defaultUser";
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Bai4 {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("huyen"));
        users.add(new User("linh"));
        users.add(new User("anh"));

        Function<User, String> getUsername = User::getUsername;

        users.stream()
                .map(getUsername)
                .forEach(System.out::println);

        Consumer<String> print = System.out::println;

        print.accept("Hello Method Reference");

        Supplier<User> createUser = User::new;

        User newUser = createUser.get();
        System.out.println(newUser.getUsername());
    }
}
