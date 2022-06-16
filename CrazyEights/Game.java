/*
* Grant Rincon
* Class that contains methods for simulating and evaluating a game of Crazy Eights between two players.
*/

import java.util.LinkedList;

public class Game {
  private Dealer m_dealer;
  private LinkedList<Card> m_pile;
  private Player m_player1;
  private Player m_player2;
  private static int player1Wins = 0;
  private static int player2Wins = 0;
  private static int player1Points = 0;
  private static int player2Points = 0;
  private int loserHandSize = 0;
  private static int stockDepletions = 0;
  private static int wildEightPlayed = 0;

  /*
  * Default constructor for Game object instance
  */
  public Game() {
    m_dealer = new Dealer();
    m_pile = m_dealer.deals(1);
    m_player1 = new Player(1, m_dealer, m_pile);
    m_player2 = new Player(2, m_dealer, m_pile);
  }

  /*
  * Evaluates the summary of play()'s results. Increases the win tally,
  * length by the amount of cards in the losing player's hand, and point total of the winning player,
  * unless the game ended in a draw.
  */
  private void evalGameSummary() {

    if (m_player1.getHandSize() < m_player2.getHandSize()) { // Player 1 wins
      int points = 0;
      int length = m_player2.getHandSize();
      player1Wins++;
      for (int i = 0; i < length; i++) {
        Card currCard = m_player2.getHand().get(i);
        if (currCard.getRank() == 8) {
          points += 50;
        }
        else if (currCard.getRank() <= 10 && currCard.getRank() >= 2) {
          points += currCard.getRank();
        }
        else if (currCard.getRank() < 14) {
          points += currCard.getRank();
        }
        else if (currCard.getRank() == 14){
          points += 1;
        }
      }
      loserHandSize += length;
      player1Points += points;
    }
    else if (m_player1.getHandSize() > m_player2.getHandSize()) { // Player 2 wins
      // Player 2 wins
      int points = 0;
      int length = m_player1.getHandSize();
      // Player 1 wins
      player2Wins++;
      for (int i = 0; i < length; i++) {
        Card currCard = m_player1.getHand().get(i);
        if (currCard.getRank() == 8) {
          points += 50;
        }
        else if (currCard.getRank() <= 10 && currCard.getRank() >= 2) {
          points += currCard.getRank();
        }
        else if (currCard.getRank() < 14) {
          points += currCard.getRank();
        }
        else if (currCard.getRank() == 14){
          points += 1;
        }
      }
      loserHandSize += length;
      player2Points += points;
    }
  }
  private Player switchTurn(Player currPlayer) {
    if (currPlayer == m_player1) {
      currPlayer = m_player2;
    }
    else {
      currPlayer = m_player1;
    }
    return currPlayer;
  }
  public Dealer getDealer() {
    return m_dealer;
  }
  public LinkedList<Card> getPile() {
    return m_pile;
  }
  public Player getPlayerOne() {
    return m_player1;
  }
  public Player getPlayerTwo() {
    return m_player2;
  }
  public int getStockDepletions() {
    return stockDepletions;
  }
  public int getPlayer1Wins() {
    return player1Wins;
  }
  public int getPlayer2Wins() {
    return player2Wins;
  }
  public int getPlayer1Points() {
    return player1Points;
  }
  public int getPlayer2Points() {
    return player2Points;
  }
  public int getLoserHandSize() {
    return loserHandSize;
  }
  public int getWild8Count() {
    return wildEightPlayed;
  }
  /*
  * Simulates the game of Crazy Eights.
  */
  public void play() {
    int length = m_pile.size() - 1;
    Player currPlayer = m_player1;
    Card topOfPile = m_pile.get(length);
    int againstRank = topOfPile.getRank();
    int againstSuit = topOfPile.getSuit();

    while (m_player1.getHandSize() > 0 && m_player2.getHandSize() > 0) {
      Card played = currPlayer.takeTurn(topOfPile);

      if (played == null || played.getRank() == -1) {
        if (played.getRank() == -1) {
          stockDepletions++;
        }
        currPlayer = switchTurn(currPlayer);
        played = currPlayer.takeTurn(topOfPile);
        if (played == null || played.getRank() == -1) {
          break;
        }
      }
      m_pile.add(played);
      length++;
      topOfPile = m_pile.get(length);

      if (played.getRank() == 8) {
        if (againstRank != 8) {
          wildEightPlayed++;
        }
        againstRank = 8;
        againstSuit = currPlayer.newSuit();
        currPlayer = switchTurn(currPlayer);
        continue;
      }
      if (played.getRank() == againstRank) {
        againstSuit = played.getSuit();
        currPlayer = switchTurn(currPlayer);
        continue;
      }
      else if (played.getSuit() == againstSuit) {
        againstRank = played.getRank();
        currPlayer = switchTurn(currPlayer);
        continue;
      }
    }
    System.out.println("Player 1's Hand Size: " + m_player1.getHandSize());
    System.out.println("Player 2's Hand Size: " + m_player2.getHandSize());
    System.out.println("Game Finished");
  }
}
