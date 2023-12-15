package lotto.domain.winningLotto;

import lotto.domain.Lotto;

public class WinningLotto {
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }
}
