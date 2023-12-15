package lotto.utils;

import java.text.DecimalFormat;

public class Formatter {
    private static final String WON_FORMAT = "###,###";

    public static String formatIntoWon(int value) {
        DecimalFormat formatter = new DecimalFormat(WON_FORMAT);
        return formatter.format(value);
    }
}
