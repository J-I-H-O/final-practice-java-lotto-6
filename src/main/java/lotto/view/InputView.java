package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println("\n" + INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
