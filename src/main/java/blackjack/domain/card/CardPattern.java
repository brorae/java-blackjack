package blackjack.domain.card;

public enum CardPattern {
    DIAMOND("다이아몬드"),
    CLOVER("클로버"),
    HEART("하트"),
    SPADE("스페이드");

    private final String pattern;

    CardPattern(final String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}