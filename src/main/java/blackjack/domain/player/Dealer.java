package blackjack.domain.player;

import blackjack.domain.card.Card;
import java.util.List;

public class Dealer extends Player {

    private static final int MAX_SCORE_TO_PICK = 16;

    public Dealer(final List<Card> cards) {
        super("딜러", cards);
    }

    @Override
    public boolean canDrawCard() {
        return getTotalScore() <= MAX_SCORE_TO_PICK;
    }
}
