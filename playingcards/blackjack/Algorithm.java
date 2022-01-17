// Copyrights (c) 2021, Rice University.

package edu.rice.cs.playingcards.blackjack;

import edu.rice.cs.playingcards.card.Card;

/**
 * The base class to represent an algorithm for deciding wheether to hit or pass on a hand in the
 * Blackjack game. The actual algorithm should be implemented in extending classes.<p/>
 *
 * Note that the constructor below only takes the player's hand as a parameter. This is
 * intentional: first, dumb algorithm might ignore the dealer's card; second, we also want to use
 * an algorithm to implement the fixed strategy of the dealer.
 *
 * @author aps@rice.edu, Alexei Stolboushkin
 */
public abstract class Algorithm {
  /**
   * Describes four possible decisions at the current state of play.
   */
  public enum Move {
    HIT,
    STAY,
    SPLIT,
    DOUBLE
  }

  /**
   * Creates a new instance of the algorithm to be applied to the given initial player's hand.
   */
  protected Algorithm(Hand hand) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the current player hand. The returned hand cannot be mutated.
   */
  public final Hand.ImmutableHand getHand() {
    throw new UnsupportedOperationException();
  }

  /**
   * This is the only place where algorithms would be different from one another. The method,
   * for the current state of play, makes a decision about the next move.
   *
   * @throws IllegalStateException if the hand is bust or empty.
   */
  public abstract Move move();

  /**
   * Grows the underlying hand by adding a new card to it. This is happening when the
   * {@link #move()} method returned {@code HIT}, however, this orchestration should be happening
   * outside and this class is not responsible for consistency.
   */
  public final void feedNextCard(Card nextCard) {
    throw new UnsupportedOperationException();
  }
}
