package blackjack.domain.result;

import blackjack.domain.player.Dealer;
import blackjack.domain.player.User;
import blackjack.domain.player.Users;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<User, Result> userResult;
    private final Map<Result, Integer> dealerResult;

    private GameResult(final Map<User, Result> userResult, final Map<Result, Integer> dealerResult) {
        this.userResult = userResult;
        this.dealerResult = dealerResult;
    }

    public static GameResult createPlayerGameResult(final Dealer dealer, final Users users) {
        Map<User, Result> userResult = new HashMap<>();
        Map<Result, Integer> dealerResult = initializeDealerResultCount();
        for (final User user : users.getUsers()) {
            userResult.put(user, user.findResult(dealer));
            dealerResult.compute(dealer.findResult(user), (result, count) -> count + 1);
        }
        return new GameResult(userResult, dealerResult);
    }

    private static Map<Result, Integer> initializeDealerResultCount() {
        return new HashMap<>(Map.ofEntries(
                Map.entry(Result.WIN, 0),
                Map.entry(Result.DRAW, 0),
                Map.entry(Result.LOSE, 0)
        ));
    }

    public Map<User, Result> getUserResult() {
        return Collections.unmodifiableMap(userResult);
    }

    public Map<Result, Integer> getDealerResult() {
        return Collections.unmodifiableMap(dealerResult);
    }
}