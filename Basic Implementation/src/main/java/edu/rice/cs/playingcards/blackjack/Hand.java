// Copyrights (c) 2021, Rice University.

package edu.rice.cs.playingcards.blackjack;

import com.google.common.collect.ImmutableList;
import edu.rice.cs.playingcards.card.Card;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * The class represents a "hand", i.e., a collection or cards on the player or house side. On every
 * hit, the hand grows by one new card.
 *
 * @author aps@rice.edu, Alexei Stolboushkin
 */
@NotThreadSafe
public class Hand {
  /**
   * The only difference from the outer class is that instances of {@link ImmutableHand} cannot
   * be mutated, i.e., disables the {@link #withAdditionalCard(Card)} method.
   */
  public final class ImmutableHand extends Hand {
    @Override
    public final Hand withAdditionalCard(Card card) {
      // Note that this implementation is actually correct.
      throw new UnsupportedOperationException();
    }
  }


  private Hand() {}

  /**
   * Creates and returns an empty hand.
   */
  public static Hand empty() {
    throw new UnsupportedOperationException();
  }

  /**
   * Adds a new card to the hand, and also returns the mutated hand.
   */
  public Hand withAdditionalCard(Card card) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a replica of this hand.
   */
  public final Hand replica() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns all cards currently in the hand.
   */
  public final Iterable<Card> cards() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns thesize, i.e., the number of cards, in the hand.
   */
  public final int size() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns {@code true} if this hand represents a blackjack; and returns {@code false} otherwise.
   */
  public final boolean isBlackJack() {
    throw new UnsupportedOperationException();
  }

  /**
   * Computes and returns the numeric value(s) of the hand. Typically, it is one value; however,
   * Ace could be evaluated as either {@code 1} or {@code 11}, hence the plural. The
   * values are returned in the descending order.<p/>
   *
   * Note that the max size of the returned list is 2: however many aces are present in the hand,
   * only one of them could count as 11 without going bust.<p/>
   *
   * As an example, when the hand is {@code {Ace-Hearts, Ace-Diamonds, 2-of-Clubs}}, the
   * method returns two values, {14, 4}.<p/>
   *
   * The method trims the resulting values as follows:
   * <ul>
   *   <li>
   *     if one of the values is {@code 21}, the method returns the {@code {21}}
   *        singleton;
   *   </li>
   *   <li>
   *     if some of the values if {@code < 21}, the method returns all such values, trimming
   *        out any values {@code > 21}. For example, when the hand is {@code {Ace-Hearts,
   *        3-of-Diamonds, 2-of-Clubs}}, the method returns {@code {16, 6}}, however,
   *        when the hand is {@code {Ace-Hearts, 9-of-Diamonds, 2-of-Clubs}}, the method trims
   *        {@code 22} and returns {@code {12}};
   *   </li>
   *   <li>
   *     finally, if all the values are {@code > 21}, the method returns the singleton
   *        containing the smallest such value. For example, when the hand is {@code {Ace-Hearts,
   *        6-of-Diamonds, 7-of-Spades, 8-of-Clubs}}, the method trims {@code 32} and
   *        returns the {@code {22}} singleton.
   *   </li>
   * </ul>
   *
   * @throws {@link }{@link IllegalStateException}} if the hand is empty.
   */
  public final ImmutableList<Integer> values() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns {@code true} if this hand is bust; and returns {@code false} otherwise.
   */
  public final boolean isBust() {
    throw new UnsupportedOperationException();
  }
}
