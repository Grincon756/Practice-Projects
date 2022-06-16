/*
* Driver class that allows the user to simulate a self-determind number of
* Crazy Eights games.
*/
import java.util.Scanner;
import java.util.InputMismatchException;;

public class Simulation {

  public static void simulate(int n) {

    while (n > 0) {
      Game currRound = new Game();
      currRound.play();
      n--;
    }
  }

  public static void main(String[] args) {
    int games;
    Scanner scnr = new Scanner(System.in);
    System.out.println("How many games of Crazy Eights do you want to simulate?");
    while (true) {
      try {
        games = scnr.nextInt();
        simulate(games);
      }
      catch (InputMismatchException e) {
        System.out.println("Please input a valid number of games to simulate.");
      }
    }
  }
}
