package BTTH.Service;

import BTTH.Tier.Bronze;
import BTTH.Tier.Gold;
import BTTH.Tier.Silver;
import BTTH.Tier.Tier;
import bai1.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public List<User> getVerifiedUsers(List<User> users) {

        return users.stream()
                .filter(User::isVerified)
                .collect(Collectors.toList());
    }

    public Tier classifyTier(long months) {

        return switch ((int) months) {

            default -> {
                if (months > 24) yield new Gold();
                else if (months > 12) yield new Silver();
                else yield new Bronze();
            }
        };
    }
}