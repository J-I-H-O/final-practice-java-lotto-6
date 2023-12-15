package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchasePrice;
import lotto.domain.winningLotto.WinningLotto;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class MainController {
    public void run() {
        PurchasePrice price = purchase();
        LottoMachine lottoMachine = new LottoMachine(price);

        OutputView.printLottos(lottoMachine);

        Lotto winningNumbers = getWinningNumbers();

    }

    private PurchasePrice purchase() {
        while (true) {
            try {
                String inputPrice = InputView.inputPurchasePrice();
                return new PurchasePrice(inputPrice);
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = InputView.inputWinningNumbers();
                List<Integer> numbers = Parser.parseNumbers(inputWinningNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }
    }
}
