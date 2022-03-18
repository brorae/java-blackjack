package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CardTest {

    @Test
    @DisplayName("하트 타입의 숫자 2카드 생성을 확인한다")
    void createHeartNumberCard() {
        final Card card = new Card(Denomination.HEART, Suit.TWO);
        final String expectedPattern = "하트";
        final int expectedNumber = 2;

        final String actualPattern = card.getDenomination();
        final int actualNumber = card.getSuit();
        assertThat(actualPattern).isEqualTo(expectedPattern);
        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @Test
    @DisplayName("클로버 타입의 숫자 2카드 생성을 확인한다")
    void createCloverNumberCard() {
        final Card card = new Card(Denomination.CLOVER, Suit.THREE);
        final String expectedPattern = "클로버";
        final int expectedNumber = 3;

        final String actualPattern = card.getDenomination();
        final int actualNumber = card.getSuit();
        assertThat(actualPattern).isEqualTo(expectedPattern);
        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @Test
    @DisplayName("스페이드 타입의 King 카드 생성을 확인한다.")
    void createSpecialTenCard() {
        final Card card = new Card(Denomination.SPADE, Suit.KING);
        final String expectedPattern = "스페이드";
        final int expectedNumber = 10;

        final String actualPattern = card.getDenomination();
        final int actualNumber = card.getSuit();
        assertThat(actualPattern).isEqualTo(expectedPattern);
        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @Test
    @DisplayName("다이아몬드 타입의 Ace 카드 생성을 확인한다.")
    void createSpecialQueenCard() {
        final Card card = new Card(Denomination.DIAMOND, Suit.ACE);
        final String expectedPattern = "다이아몬드";
        final int expectedNumber = 11;

        final String actualPattern = card.getDenomination();
        final int actualNumber = card.getSuit();
        assertThat(actualPattern).isEqualTo(expectedPattern);
        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @ParameterizedTest(name = "카드의 에이스 카드 여부는 {1}이다.")
    @MethodSource("provideCardAndExpected")
    @DisplayName("에이스 카드인지 확인한다.")
    void isAceCard(final Card card, final boolean expected) {
        final boolean actual = card.isAceCard();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCardAndExpected() {
        return Stream.of(
                Arguments.of(new Card(Denomination.SPADE, Suit.ACE), true),
                Arguments.of(new Card(Denomination.HEART, Suit.ACE), true),
                Arguments.of(new Card(Denomination.DIAMOND, Suit.TWO), false),
                Arguments.of(new Card(Denomination.CLOVER, Suit.TEN), false)
        );
    }
}


