package blackjack.domain.card;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeck;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.CardPattern;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardDeckGenerator {

    public static CardDeck createCardDeck() {
        List<Card> cards = new LinkedList<>();
        for (final CardPattern cardPattern : CardPattern.values()) {
            addCard(cards, cardPattern);
        }
        Collections.shuffle(cards);
        return new CardDeck(cards);
    }

    private static void addCard(List<Card> cards, CardPattern cardPattern) {
        for (final CardNumber cardNumber : CardNumber.values()) {
            cards.add(new Card(cardPattern, cardNumber));
        }
    }
}