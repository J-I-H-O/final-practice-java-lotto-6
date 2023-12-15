package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);

        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOverRange = numbers.stream()
                .anyMatch(number -> !(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER));

        if (isOverRange) {
            throw new IllegalArgumentException(NOT_IN_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int size = numbers.size();
        long uniqueCount = numbers.stream()
                .distinct()
                .count();

        if (size != uniqueCount) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
