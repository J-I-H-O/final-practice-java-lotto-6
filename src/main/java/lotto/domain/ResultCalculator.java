package lotto.domain;

import lotto.domain.lotto.LottoMachine;
import lotto.domain.winningLotto.WinningLotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResultCalculator {
    private final Map<Prize, Integer> resultCount = new HashMap<>();

    public ResultCalculator(LottoMachine lottoMachine, WinningLotto winningLotto) {
        initResultCount();
        calculateResultCount(lottoMachine, winningLotto);
    }

    private void initResultCount() {
        Arrays.stream(Prize.values())
                .forEach(value -> resultCount.put(value, 0));
    }

    private void calculateResultCount(LottoMachine lottoMachine, WinningLotto winningLotto) {
        lottoMachine.getLottos()
                .stream()
                .map(lotto -> lotto.calculatePrize(winningLotto))
                .filter(Objects::nonNull)
                .forEach(this::addCount);
    }

    private void addCount(Prize prize) {
        resultCount.put(prize, resultCount.get(prize) + 1);
    }

    public double calculateBenefitRatio() {
        return 0;
    }

    private int calculateTotalBenefit() {
        return 0;
    }

    public Map<Prize, Integer> getResultCount() {
        return resultCount;
    }
}
