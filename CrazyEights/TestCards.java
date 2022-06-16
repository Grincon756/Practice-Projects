import java.util.LinkedList;

public class TestCards {

  public static void main(String[] args) {
    Dealer Jay = new Dealer();
    Card card1 = new Card();
    LinkedList<Card> pile = Jay.deals(1);
    pile.add(card1);
    Deck deck1 = new Deck();
    LinkedList<Card> deck2 = Jay.deals(52);
    Deck deck3 = new Deck(deck1);
    Card card2 = new Card(3, 12);
    Card card3 = new Card(card1);
    Card card4 = new Card(deck1.deal());

    System.out.println(pile.get(0));
  }
}
