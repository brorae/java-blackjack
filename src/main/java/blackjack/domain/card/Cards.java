package blackjack.domain.card;

import blackjack.domain.Result;
import java.util.Collections;
import java.util.List;

public class Cards {

    private static final int ACE_VALUE = 10;

    private List<Card> cards;
    private Boolean isBlackJack;

    public Cards(List<Card> cards) {
        this.cards = cards;
        isBlackJack = calculateScore() == Result.BLACK_JACK_SCORE;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        int totalScore = getTotalScore();
        int countOfAce = getCountOfAce();
        while (countOfAce-- > 0 && totalScore > Result.BLACK_JACK_SCORE) {
            totalScore -= ACE_VALUE;
        }
        return totalScore;
    }

    public Boolean getBlackJack() {
        return isBlackJack;
    }

    private int getCountOfAce() {
        return (int) cards.stream()
                .filter(Card::isAceCard)
                .count();
    }

    private int getTotalScore() {
        return cards.stream()
                .mapToInt(Card::getCardNumber)
                .sum();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
