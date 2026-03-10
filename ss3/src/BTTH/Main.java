package BTTH;

import BTTH.Service.UserService;
import BTTH.Tier.Tier;
import BTTH.model.PublicUser;
import BTTH.model.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<bai1.User> users = List.of(

                new User("U01","alice@gmail.com","123",true, LocalDate.of(2020,1,1)),
                new User("U02","bob@gmail.com","123",false, LocalDate.of(2023,1,1)),
                new User("U03","charlie@gmail.com","123",true, LocalDate.of(2021,5,10)),
                new User("U04","david@gmail.com","123",true, LocalDate.of(2024,1,1)),
                new User("U05","emma@gmail.com","123",false, LocalDate.of(2022,3,1))
        );

        UserService service = new UserService();

        // Bước 2: lọc verified
        List<User> verifiedUsers = service.getVerifiedUsers(users);

        // Bước 3: convert sang PublicUser
        List<PublicUser> publicUsers = verifiedUsers.stream()
                .map(user -> {

                    long months = Period.between(
                            user.getCreatedAt(),
                            LocalDate.now()
                    ).toTotalMonths();

                    Tier tier = service.classifyTier(months);

                    return new PublicUser(
                            user.getId(),
                            user.getEmail(),
                            tier
                    );
                })
                .toList();

        // Bước 4: in report
        publicUsers.forEach(u -> {

            String report = """
                    ------------------------
                    ID: %s
                    Email: %s
                    Tier: %s
                    ------------------------
                    """.formatted(
                    u.id(),
                    u.email(),
                    u.tier()
            );

            System.out.println(report);
        });
    }
}
