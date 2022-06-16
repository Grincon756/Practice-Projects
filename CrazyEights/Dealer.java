/*
* Grant Rincon
* A class representing a dealer of a standard 52 card deck.
*/

import java.util.LinkedList;

public class Dealer {
  private Deck m_deck = new Deck();

  public Dealer() {
    m_deck = new Deck();
  }
  /*
  * Method that builds a new linked list of cards out of random cards from the
  * dealer's deck.
  */
  public LinkedList<Card> deals(int n) {
    LinkedList<Card> d = new LinkedList<Card>();
    int count = 0;
    while (count < n && m_deck.size() > 0) {
      d.add(m_deck.deal());
      count++;
    }
    return d;
  }
  public Deck getDealerDeck() {
    return m_deck;
  }
  public int size() {
    return m_deck.size();
  }
  public String toString() {
    return m_deck.toString();
  }
}
