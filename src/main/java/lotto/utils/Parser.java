package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String REGEX = ",";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 입력 값이 올바르지 않습니다.";

    public static List<Integer> parseNumbers(String inputWinningNumbers) {
        String[] split = inputWinningNumbers.split(REGEX, -1);

        try {
            return Arrays.stream(split)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }
}
