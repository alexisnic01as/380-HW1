// Copyrights (c) 2021, Rice University.

package edu.rice.cs.playingcards.card;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Map;
import java.util.Objects;

/**
 * The class implements cards from a 52-card deck of French-suited playing cards, see {@link
 * <a href="https://en.wikipedia.org/wiki/Standard_52-card_deck">...</a>}.
 *
 * @author aps@rice.edu, Alexei Stolboushkin
 */
@ThreadSafe
public final class Card {
  public enum Suit {
    SPADES,
    CLUBS,
    DIAMONDS,
    HEARTS;

    private static final Map<Suit, Character> UTF8 = ImmutableMap.of(
        SPADES, '\u2660',
        CLUBS, '\u2667',
        DIAMONDS, '\u2662',
        HEARTS, '\u2661');
    private static final Map<Suit, String> NAMES;

    static {
      ImmutableMap.Builder<Suit, String> namesBuilder = ImmutableMap.builder();
      for (Suit suit : Suit.values()) {
        String name = suit.name();
        namesBuilder.put(
            suit,
            name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
      }
      NAMES = namesBuilder.build();
    }

    @Override
    public final String toString() {
      return NAMES.get(this);
    }

    public final char utf8() {
      return UTF8.get(this);
    }
  }

  public enum Rank {
    ACE,
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
    JACK, QUEEN, KING;


    private static final Map<Rank, String> AS_STRINGS = ImmutableMap.<Rank, String>builder()
        .put(ACE, "A")
        .put(TWO, "2")
        .put(THREE, "3")
        .put(FOUR, "4")
        .put(FIVE, "5")
        .put(SIX, "6")
        .put(SEVEN, "7")
        .put(EIGHT, "8")
        .put(NINE, "9")
        .put(TEN, "10")
        .put(JACK, "J")
        .put(QUEEN, "Q")
        .put(KING, "K")
        .build();

    @Override
    public final String toString() {
      return AS_STRINGS.get(this);
    }
  }

  private final Rank rank;
  private final Suit suit;

  Card(Rank rank, Suit suit) {
    this.rank = Preconditions.checkNotNull(rank);
    this.suit = Preconditions.checkNotNull(suit);
  }

  public final Rank rank() {
    return rank;
  }

  public final Suit suit() {
    return suit;
  }

  @Override
  public final String toString() {
    return rank.toString() + " of " + suit;
  }

  public final String utf8() {
    return rank.toString() + suit.utf8();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    Card card = (Card) o;
    return (rank == card.rank) && (suit == card.suit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank, suit);
  }
}
