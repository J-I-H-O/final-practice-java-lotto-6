package lotto.view;

import lotto.domain.Prize;
import lotto.domain.ResultCalculator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PRINT_LOTTOS_MESSAGE = "%d개를 구매했습니다.";
    private static final String PRINT_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String PRINT_RESULT_FORMAT = "%s (%d원) - %d개\n";

    public static void printLottos(LottoMachine lottoMachine) {
        System.out.println(String.format("\n" + PRINT_LOTTOS_MESSAGE,
                lottoMachine.getPrice().calculateLottoCount()));

        List<Lotto> lottos = lottoMachine.getLottos();
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printResult(ResultCalculator resultCalculator) {
        Map<Prize, Integer> resultCount = resultCalculator.getResultCount();

        System.out.println("\n" + PRINT_RESULT_MESSAGE);
        Arrays.stream(Prize.values())
                .forEach(value -> {
                    System.out.printf(PRINT_RESULT_FORMAT,
                            value.getDescription(),
                            value.getPrice(),
                            resultCount.get(value)
                    );
                });
    }
}
