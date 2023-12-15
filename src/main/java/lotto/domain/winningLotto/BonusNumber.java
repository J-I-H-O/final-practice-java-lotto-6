package lotto.domain.winningLotto;

public class BonusNumber {
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값은 입력할 수 없습니다.";
    private static final String NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 45;

    private final int number;

    public BonusNumber(String numberInput) {
        validateNumeric(numberInput);
        int number = Integer.parseInt(numberInput);
        validateRange(number);

        this.number = number;
    }

    private void validateNumeric(String numberInput) {
        try {
            Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void validateRange(int number) {
        if (MIN_NUMBER_VALUE <= number && number <= MAX_NUMBER_VALUE) {
            return;
        }
        throw new IllegalArgumentException(NOT_IN_RANGE_ERROR_MESSAGE);
    }

    public int getNumber() {
        return number;
    }
}
