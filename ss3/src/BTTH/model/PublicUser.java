package BTTH.model;

import BTTH.Tier.Tier;

public record PublicUser(
        String id,
        String email,
        Tier tier
) {
}