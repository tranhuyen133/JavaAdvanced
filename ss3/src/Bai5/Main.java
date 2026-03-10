package Bai5;

import java.util.*;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alexander", "a@gmail.com"),
                new User("bob", "b@gmail.com"),
                new User("charlotte", "c@gmail.com"),
                new User("benjamin", "d@gmail.com"),
                new User("anna", "e@gmail.com"),
                new User("christopher", "f@gmail.com")
        );

        users.stream()
                .sorted(Comparator.comparingInt(user -> user.username().length()).reversed())
                .limit(3)
                .forEach(user -> System.out.println(user.username()));
    }
}
