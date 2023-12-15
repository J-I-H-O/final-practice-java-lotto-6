package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIFTH(5000, "3개 일치", 3, false),
    FORTH(50_000, "4개 일치", 4, false),
    THIRD(1_500_000, "5개 일치", 5, false),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치", 5, true),
    FIRST(2_000_000_000, "6개 일치", 6, false);

    private final int price;
    private final String description;
    private final int matchCount;
    private final boolean matchesBonus;

    Prize(int price, String description, int matchCount, boolean matchesBonus) {
        this.price = price;
        this.description = description;
        this.matchCount = matchCount;
        this.matchesBonus = matchesBonus;
    }

    public static Prize findPrize(int matchCount, boolean matchesBonus) {
        if (matchCount == SECOND.matchCount && matchesBonus == SECOND.matchesBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount && matchesBonus == THIRD.matchesBonus) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchesBonus() {
        return matchesBonus;
    }
}
