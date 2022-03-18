package blackjack.domain.card;

import java.util.LinkedList;
import java.util.List;

public class TestDeckGenerator implements CardDeckGenerator {

    @Override
    public CardDeck createCardDeck() {
        List<Card> cards = new LinkedList<>();
        for (final Suit cardPattern : Suit.values()) {
            addCard(cards, cardPattern);
        }
        return new CardDeck(cards);
    }

    private void addCard(List<Card> cards, Suit cardPattern) {
        for (final Denomination cardNumber : Denomination.values()) {
            cards.add(new Card(cardPattern, cardNumber));
        }
    }
}
