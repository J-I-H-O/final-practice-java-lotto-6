package lotto.controller;

import lotto.domain.ResultCalculator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.winningLotto.BonusNumber;
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

        WinningLotto winningLotto = getWinningLotto();

        ResultCalculator resultCalculator = new ResultCalculator(lottoMachine, winningLotto);

        OutputView.printResult(resultCalculator);
        OutputView.printBenefitRatio(resultCalculator, lottoMachine);
    }

    private PurchasePrice purchase() {
        while (true) {
            try {
                String priceInput = InputView.inputPurchasePrice();
                return new PurchasePrice(priceInput);
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumbers = getWinningNumbers();
        while (true) {
            BonusNumber bonusNumber = getBonusNumber();
            try {
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = InputView.inputWinningNumbers();
                List<Integer> numbers = Parser.parseNumbers(winningNumbersInput);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber() {
        while (true) {
            try {
                String bonusNumberInput = InputView.inputBonusNumber();
                return new BonusNumber(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
    }
}
