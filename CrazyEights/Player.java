/*
* Grant Rincon
* Class that represents a player in a card game of Crazy Eights.
*/

import java.util.LinkedList;

public class Player {
  private int turn;
  private LinkedList<Card> hand = new LinkedList<Card>();
  private Dealer m_dealer;
  private LinkedList<Card> m_pile;

  /*
  * Single Overloaded constructor
  */
  public Player(int turn, Dealer m_dealer, LinkedList<Card> m_pile) {
    this.turn = turn;
    this.m_dealer = m_dealer;
    this.m_pile = m_pile;
    hand = m_dealer.deals(5);
  }
  /*
  * Accessors
  */
  public int getHandSize() {
    return hand.size();
  }
  public LinkedList<Card> getHand() {
    return hand;
  }
  public int getTurn() {
    return turn;
  }
  /*
  * Method to see if the player has a playable card in their hand
  */
  private Card searchHand(Card lastPlayed) {
    int indexOf8 = -1;
    double chanceOf8 = Math.random();

    for (int i = 0; i < hand.size(); i++) {
      if (hand.get(i).getRank() == 8 && chanceOf8 <= 0.1) {
        Card cardToPlay = hand.remove(i);
        return cardToPlay;
      }
      // Returns the first card in the Deck that has the same rank or suit as the lastPlayed that is not an 8
      if ((hand.get(i).getRank() == lastPlayed.getRank() ||
      hand.get(i).getSuit() == lastPlayed.getRank()) &&
      (hand.get(i)).getRank() != 8) {
        Card cardToPlay = hand.remove(i);
        return cardToPlay;
      }
      // sets indexOf8 to the index value of the last 8 in the Player's hand
      if (hand.get(i).getRank() == 8) {
        indexOf8 = i;
      }
    }
    // If no other viable cards were found, returns the 8 stored at index indexOf8
    if (indexOf8 != -1) {
      return hand.remove(indexOf8);
    }
    // returns null if a viable card is not in hand
    return null;
  }
  /*
  * Private helper method that searches through the m_dealer's deck until a playable card is found.
  * If the pulled has a size of zero, then the dealer's deck is empty, and a (-1, -1) card is returned named 'empty'
  * If the card in pulled has the same rank or suit as rankNeeded or suitNeeded, respectively, or an 8 is pulled,
  * the card is removed and returned.
  *
  */
  private Card searchDeck(int rankNeeded, int suitNeeded) {
    LinkedList<Card> pulled = m_dealer.deals(1); // Linked List is used to deal one card at a time from the dealer's deck
    Card needed = new Card(rankNeeded, suitNeeded);
    System.out.println("Player " + turn + " is against: " + needed.toString());
    if (pulled.size() == 0) {
      Card empty = new Card(-1, -1);
      return empty;
    }

    if (pulled.get(0).getRank() == rankNeeded ||
    pulled.get(0).getSuit() == suitNeeded ||
    pulled.get(0).getRank() == 8) {
      System.out.println("Player " + turn + " pulled: " + pulled.get(0).toString());
      return pulled.remove(0);
    }
    hand.addAll(pulled);
    return null;
  }
  /*
  * Method that comprises the player's turn process
  * cardToPlay is constructed from a card in the player's hand
  * If a viable card was not found, then the dealer's deck is searched until a viable card is found
  */
  public Card takeTurn(Card lastPlayed) {
      Card cardToPlay = searchHand(lastPlayed);
      while (cardToPlay == null || cardToPlay.getRank() != -1) {
        cardToPlay = searchDeck(lastPlayed.getRank(), lastPlayed.getSuit());
      }
      return cardToPlay;
  }
  /*
  * Method that randomely selects one of four ints that represent card suits
  */
  public int newSuit() {
    double chance = Math.random();
    if (chance <= 0.25) {
      return 0;
    }
    else if (chance > 0.25 && chance <= 0.5) {
      return 1;
    }
    else if (chance > 0.5 && chance <= 0.75) {
      return 2;
    }
    return 3;
  }
 }
