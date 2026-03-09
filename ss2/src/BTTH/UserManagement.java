package BTTH;

import java.util.function.*;

public class UserManagement {

    Supplier<User> createUser = User::new;

    Predicate<User> isActiveUser = user ->
            user.getStatus().equals("ACTIVE");

    Function<User, String> getEmail = User::getEmail;

}
