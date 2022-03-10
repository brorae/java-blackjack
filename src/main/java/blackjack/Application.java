package blackjack;

import blackjack.controller.GameController;
import blackjack.domain.CardDeckGenerator;

public class Application {
    public static void main(String[] args) {
        try {
            GameController gameController = new GameController(CardDeckGenerator.createCardDeckByCardNumber());
            gameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
