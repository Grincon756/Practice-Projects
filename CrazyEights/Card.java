/**
* Grant Rincon
* A class representing a card from a standard 52 card deck.
*/

public class Card {
  private int suit;
  private int rank;
  public static final int HEARTS = 0;
  public static final int SPADES = 1;
  public static final int CLUBS = 2;
  public static final int DIAMONDS = 3;
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  public static final int ACE = 14;

  public Card() {
    suit = 0;
    rank = 2;
  }

  public Card(int suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public Card(Card c) {
    this.suit = c.suit;
    this.rank = c.rank;
  }

  public void setSuit(int suit) {
    this.suit = suit;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public int getSuit() {
    return suit;
  }

  public int getRank() {
    return rank;
  }
  /*
  * Provides a String that denotes a card's rank and suit.
  */
  public String toString() {
    String s = "";
    if (rank == JACK) {
      s += "Jack of ";
    }
    else if (rank == QUEEN) {
      s += "Queen of ";
    }
    else if (rank == KING) {
      s += "King of ";
    }
    else if (rank == ACE){
      s += "Ace of ";
    }
    else {
      s += rank + " of ";
    }
    if (suit == HEARTS) {
      s += "Hearts";
    }
    else if (suit == SPADES) {
      s += "Spades";
    }
    else if (suit == CLUBS) {
      s += "Clubs";
    }
    else if (suit == DIAMONDS) {
      s += "Diamonds";
    }
    return s;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Card)) {
      return false;
    }
    Card c = (Card) o;
    return this.rank == c.rank && this.suit == c.suit;
  }

}
