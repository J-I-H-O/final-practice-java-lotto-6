package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

import java.util.List;

public class OutputView {
    private static final String PRINT_LOTTOS_MESSAGE = "%d개를 구매했습니다.";

    public static void printLottos(LottoMachine lottoMachine) {
        System.out.println(String.format("\n" + PRINT_LOTTOS_MESSAGE,
                lottoMachine.getPrice().calculateLottoCount()));

        List<Lotto> lottos = lottoMachine.getLottos();
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
