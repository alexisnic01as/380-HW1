// Copyrights (c) 2021, Rice University.

package edu.rice.cs.playingcards.card;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The class implements a 52-card deck of French-suited playing cards, see {@link
 * <a href="https://en.wikipedia.org/wiki/Standard_52-card_deck">...</a>}.<p/>
 *
 * The class has only one public method -- it is the static {@link #newShuffledDeck()}, which
 * returns a newly shuffled deck of cards as an instance of the {@link ShuffledAndDispensedDeck}.
 *
 * @author aps@rice.edu, Alexei Stolboushkin
 */
@ThreadSafe
public final class Deck {
  private static final List<Card> DECK;

  static {
    ImmutableList.Builder<Card> deckBuilder = ImmutableList.builder();
    for (Card.Rank rank : Card.Rank.values()) {
      for (Card.Suit suit : Card.Suit.values()) {
        deckBuilder.add(new Card(rank, suit));
      }
    }
    DECK = deckBuilder.build();
  }

  private Deck() {}

  /**
   * Returns a new shuffled deck with no cards dispensed yet.
   */
  public static ShuffledAndDispensedDeck newShuffledDeck() {
    return new ShuffledAndDispensedDeck();
  }

  /**
   * The class represents a deck, which has been randomly shuffled and is in the process of being
   * dispensed. Dispensing or cards from this shuffled deck is done using the {@link #next()}
   * method from the {@link Iterator} interface.<p/>
   *
   * The class is NOT Thread-Safe!!!
   */
  @NotThreadSafe
  public static final class ShuffledAndDispensedDeck implements Iterator<Card> {
    private static final Random RANDOM = new SecureRandom();

    private final List<Card> shuffled;
    private final AtomicInteger nextUnispensedCardPosition;

    private ShuffledAndDispensedDeck() {
      shuffled = Lists.newArrayList(DECK);
      Collections.shuffle(shuffled, RANDOM);
      nextUnispensedCardPosition = new AtomicInteger();
    }

    private ShuffledAndDispensedDeck(ShuffledAndDispensedDeck from) {
      Preconditions.checkNotNull(from);
      shuffled = from.shuffled;
      nextUnispensedCardPosition = new AtomicInteger(from.nextUnispensedCardPosition.get());
    }

    /**
     * Creates and returns a replica of the current deck, which is a snapshot of the current
     * object. Iterations on the original and the replica will now be happening independently.
     */
    public final ShuffledAndDispensedDeck replica() {
      return new ShuffledAndDispensedDeck(this);
    }

    @Override
    public boolean hasNext() {
      return nextUnispensedCardPosition.get() < 52;
    }

    @Override
    public Card next() {
      int current = nextUnispensedCardPosition.get();
      if (current > 51) {
        throw new NoSuchElementException();
      }
      Preconditions.checkState(
          nextUnispensedCardPosition.compareAndSet(current, current + 1),
          "Concurrent modification attempted");
      return shuffled.get(current);
    }
  }
}
