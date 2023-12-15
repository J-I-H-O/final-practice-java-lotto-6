package lotto.domain;

public class PurchasePrice {
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값은 입력할 수 없습니다.";
    private static final String MIN_PURCHASE_PRICE_ERROR_MESSAGE = "[ERROR] 1000원 이상의 금액만 입력할 수 있습니다.";
    private static final String NOT_DIVISIBLE_ERROR_MESSAGE = "[ERROR] 1000원 단위로만 입력할 수 있습니다.";
    private static final int PURCHASABLE_CURRENCY_UNIT = 1000;

    private final int money;

    public PurchasePrice(String moneyInput) {
        validateNumeric(moneyInput);
        int money = Integer.parseInt(moneyInput);
        validateMinimumPrice(money);
        validateDivisibility(money);

        this.money = money;
    }

    public int calculateLottoCount() {
        return money / PURCHASABLE_CURRENCY_UNIT;
    }

    private void validateNumeric(String moneyInput) {
        try {
            Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void validateMinimumPrice(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MIN_PURCHASE_PRICE_ERROR_MESSAGE);
        }
    }

    private void validateDivisibility(int money) {
        if (money % PURCHASABLE_CURRENCY_UNIT != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_ERROR_MESSAGE);
        }
    }
}
