package Bai1;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

class User {
    private String username;
    private String role;
    private String email;

    public User(String username, String role, String email) {
        this.username = username;
        this.role = role;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}

public class Bai1 {

    public static void main(String[] args) {

        User user = new User("huyen", "ADMIN", "huyen@gmail.com");

        Predicate<User> isAdmin = u -> u.getRole().equalsIgnoreCase("ADMIN");

        Function<User, String> getUsername = u -> u.getUsername();

        Consumer<User> printUser = u ->
                System.out.println("User: " + u.getUsername() +
                        ", Role: " + u.getRole() +
                        ", Email: " + u.getEmail());

        Supplier<User> createDefaultUser = () ->
                new User("defaultUser", "USER", "default@gmail.com");

        System.out.println("Is Admin: " + isAdmin.test(user));

        System.out.println("Username: " + getUsername.apply(user));

        printUser.accept(user);

        User newUser = createDefaultUser.get();
        System.out.println("New User: " + newUser.getUsername());
    }
}