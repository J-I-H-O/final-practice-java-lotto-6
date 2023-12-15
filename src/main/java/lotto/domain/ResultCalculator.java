package lotto.domain;

import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.winningLotto.WinningLotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResultCalculator {
    private static final int ROUNDING_POINT = 2;

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

    public BigDecimal calculateBenefitRatio(LottoMachine lottoMachine) {
        BigDecimal purchasingPrice = BigDecimal.valueOf(lottoMachine.getPrice().getMoney());
        BigDecimal totalBenefit = new BigDecimal(calculateTotalBenefit());

        return totalBenefit
                .multiply(BigDecimal.valueOf(100))
                .divide(purchasingPrice, ROUNDING_POINT, RoundingMode.HALF_EVEN);
    }

    private BigInteger calculateTotalBenefit() {
        return resultCount.entrySet()
                .stream()
                .map(entry -> BigInteger.valueOf((long) entry.getKey().getPrice() * entry.getValue()))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    public Map<Prize, Integer> getResultCount() {
        return resultCount;
    }
}
