package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    public void run() {
        PurchasePrice price = purchase();
        LottoMachine lottoMachine = new LottoMachine(price);
        OutputView.printLottos(lottoMachine);
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
}
