package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import java.util.List;

public class User extends Player {

    public User(final String name, final List<Card> cards) {
        super(name, cards);
    }

    @Override
    public boolean isPossibleToPickCard() {
        return !exceedMaxScore();
    }
}
