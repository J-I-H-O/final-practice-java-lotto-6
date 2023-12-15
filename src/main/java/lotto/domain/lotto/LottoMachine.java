package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    PurchasePrice price;
    List<Lotto> lottos = new ArrayList<>();

    public LottoMachine(PurchasePrice price) {
        this.price = price;
        generateLottos();
    }



    private void generateLottos() {
        int lottoCount = price.calculateLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public PurchasePrice getPrice() {
        return price;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
