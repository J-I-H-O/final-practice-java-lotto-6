package lotto.controller;

import lotto.domain.PurchasePrice;
import lotto.view.InputView;

public class MainController {
    public void run() {
        PurchasePrice price = purchase();
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
