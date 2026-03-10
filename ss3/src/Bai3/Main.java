package Bai3;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        Optional<User> result = repo.findUserByUsername("alice");

        result.ifPresent(user ->
                System.out.println("Welcome " + user.username())
        );

        System.out.println(
                result.map(u -> "")
                        .orElse("Guest login")
        );
    }
}
