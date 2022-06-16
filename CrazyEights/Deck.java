/**
* Grant Rincon
* A class representing a standard 52 card deck.
*/

import java.util.LinkedList;

public class Deck {
  private LinkedList<Card> m_deck = new LinkedList<Card>();

  /*
  * Default constructor that creates a LinkedList that contains 52 cards of 4 suits and all ranks.
  */
  public Deck() {
    for (int i = 0; i < 4; i++) {
      for (int j = 2; j < 15; j++) {
        Card c = new Card(i, j);
        m_deck.add(c);
      }
    }
  }
  public Deck(Deck d) {
    for (Card c : d.m_deck) {
      (this.m_deck).add(c);
    }
  }
  public String toString() {
    String s = "";
    for (Card c: m_deck) {
      s += "\n" + c.toString();
    }
    return s;
  }
  public int size() {
    int count = m_deck.size();
    return count;
  }
  /*
  * Returns a random card from the deck.
  */
  public Card deal() {
    int size = size();
    int index = (int) (Math.random() * (size));
    Card cardToDeal = m_deck.get(index);
    m_deck.remove(cardToDeal);
    return cardToDeal;
  }
}
