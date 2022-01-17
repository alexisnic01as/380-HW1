// Copyrights (c) 2021, Rice University.

package edu.rice.cs.playingcards.blackjack;

import edu.rice.cs.playingcards.card.Card;

import javax.annotation.concurrent.ThreadSafe;

/**
 * The class exposes the numeric value(s) of a card, as used in the game of Blackjack.
 *
 * @author aps@rice.edu, Alexei Stolboushkin
 */
@ThreadSafe
public final class CardValues {
  private CardValues() {}

  /**
   * Given the rank of a card, returns its numeric value(s). Typically, it is a single value, such
   * as {@code 10} for Q. However, for an ace it has to return two values: {@code 11,1}.
   */
  public static Iterable<Integer> rankValues(Card.Rank rank) {
    throw new UnsupportedOperationException();
  }

  /**
   * Similar to {@link #rankValues(Card.Rank)}, but is applies to a card.
   */
  public static Iterable<Integer> cardValues(Card card) {
    throw new UnsupportedOperationException();
  }
}
