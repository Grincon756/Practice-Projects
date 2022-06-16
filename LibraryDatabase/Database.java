/*
* Grant Rincon
* Driver class. The database stores publications in a HashMap.
*/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;
import java.io.*;

public class Database {
  public static Scanner scnr = new Scanner(System.in);

  /*
  * Method that sorts publications in ascending order of their ISBN numbers.
  */
  public static HashMap sortDatabase(HashMap<Integer, Publication> base) {
    ArrayList<Publication> storage = new ArrayList<Publication>(base.size());
    HashMap<Integer, Publication> sorted = new HashMap<Integer, Publication>(base.size());

    for (Integer i: base.keySet()) {
      storage.add(base.get(i));
    }
    Collections.sort(storage);
    for (int i = 0; i < storage.size(); i++) {
      Publication currentPub = storage.get(i);
      sorted.put(currentPub.getISBN(), currentPub);
    }
    return sorted;
  }

  /*
  * Prints out all titles of publications stored in the library database.
  */
  public static String printDatabaseTitles(HashMap<Integer, Publication> base){
    String s = "";

    for (Integer i: base.keySet()) {
      s += (base.get(i).getYearPublished() + " " + base.get(i).getTitle() + "\n");
    }
    return s;
  }

  /*
  * Prints out a publication based on a provided ISBN, if the database contains the ISBN.
  */
  public static void PrintPublication(HashMap<Integer, Publication> base, int key){
    Publication pub;
    String fileName;
    Integer currKey = key;

    System.out.println("Enter the name of the file to print at:");
    fileName = scnr.nextLine();

    if (base.containsKey(currKey)) {
      pub = base.get(currKey);
      pub.print(fileName);
    }
    else {
      System.out.println("Invalid ISBN.");
    }
  }

  /*
  * Method that allows the user to add a new publication of type book,
  * Journal, or EJournal. The user selects which type of publication to add
  * by entering (1), (2), or (3), respectively.
  */
  public static Publication CreatePublication(int n) throws InputMismatchException {
    Publication pub = null;

    while (n != -1) {
      System.out.println("Please select the type of publication that you would like to add:");
      System.out.println("(1) Book, (2) Journal, or (3) EJournal.)");
      n = scnr.nextInt();
      scnr.nextLine();
      // User enters a book.
        if (n == 1) {
          System.out.println("Enter the book's title.");
          String title = scnr.nextLine();
          System.out.println("Enter the year of publication.");
          int year = scnr.nextInt();
          scnr.nextLine();
          System.out.println("Enter the name of the publisher.");
          String publisher = scnr.nextLine();
          System.out.println("Enter the ISBN.");
          int isbn = scnr.nextInt();
          scnr.nextLine();
          System.out.println("Enter the author's name.");
          String author = scnr.nextLine();
          System.out.println("Enter the page count and binding type(hardback or paperback");
          int pageCount = scnr.nextInt();
          String bindingType = scnr.next();
          scnr.nextLine();

          pub = new Book(title, year, publisher, isbn, author, pageCount, bindingType);
          break;
        }
        // User enters a journal.
        if (n == 2) {
          System.out.println("Enter the journal's title.");
          String title = scnr.nextLine();
          System.out.println("Enter the journal's year of publication.");
          int year = scnr.nextInt();
          scnr.nextLine();
          System.out.println("Enter the journal's publisher");
          String publisher = scnr.nextLine();
          System.out.println("Enter the journal's ISBN and editor.");
          int isbn = scnr.nextInt();
          String editor = scnr.nextLine();
          System.out.println("Enter the journal's issue number.");
          int issueNum = scnr.nextInt();
          scnr.nextLine();

          pub = new Journal(title, year, publisher, isbn, editor, issueNum);
          break;
        }
        // User enters an EJournal.
        if (n == 3) {
          System.out.println("Enter the EJournal's title.");
          String title = scnr.nextLine();
          System.out.println("Enter the EJournal's year of publication.");
          int year = scnr.nextInt();
          scnr.nextLine();
          System.out.println("Enter the Ejournal's publisher");
          String publisher = scnr.nextLine();
          System.out.println("Enter the EJournal's ISBN and editor.");
          int isbn = scnr.nextInt();
          String editor = scnr.nextLine();
          System.out.println("Enter the EJournal's issue number.");
          int issueNum = scnr.nextInt();
          scnr.nextLine();
          System.out.println("Enter the EJournal's URL.");
          String url = scnr.nextLine();
          System.out.println("Enter the publication fee(to the nearest dollar).");
          int fee = scnr.nextInt();
          scnr.nextLine();

          pub = new EJournal(title, year, publisher, isbn, editor, issueNum, url, fee);
          break;
        }
        // User is finished entering new publications.
        if (n == -1) {
          continue;
        }
        else {
          System.out.println("Invalid number.");
          continue;
        }
    }
    return pub;
  }

/*
* Main method that allows the user to add new publications, print information
* on a specific publication to a .txt file, list the publication years and titles
* of all titles in the database, delete a publication from the database, or
* exit the database by entering (1), (2), (3), (4), or (5), respectively.
*/
  public static void main(String[] args) {
    boolean exitProgram = false;
    int option;
    Publication newPublication;
    HashMap<Integer, Publication> database = new HashMap<Integer, Publication>();

    while (!exitProgram) {
      System.out.println("Welcome to the library database!");
      System.out.println("Please choose from the following options:");
      System.out.println("1: Add a new publication to the database.");
      System.out.println("2: Find and print the information for a specific publication in our database.");
      System.out.println("3: List the publication years and titles of our titles.");
      System.out.println("4: Find and delete a publication from our database.");
      System.out.println("5: Exit this program.");
      try {
        option = scnr.nextInt();

        // User adds new publications to the database.
        if (option == 1) {
          System.out.println("Enter -1 when you're done adding new publications.");
          while (option != -1) {
            newPublication = CreatePublication(option);
            if (newPublication != null) {
              database.put(newPublication.getISBN(), newPublication);
              System.out.println(newPublication.getTitle() + " added to database. ");
              continue;
            }
            database = sortDatabase(database);
            System.out.println("Finished adding publications.");
            option = -1;
          }
        }

        // User prints a publication to a database.
        if (option == 2) {
          while (option != -1) {
            System.out.println("Enter the ISBN of the item that you want to print. Enter -1 to stop printing publications.");
            option = scnr.nextInt();
            scnr.nextLine();
            if (option == -1) {
              break;
            }
            PrintPublication(database, option);
          }
        }

        // User lists the years and titles of publications in the database.
        if (option == 3) {
          System.out.println("Years and titles of database items:");
          System.out.println(printDatabaseTitles(database));
        }

        // User decides to delete a publication from the database.
        if (option == 4) {
          System.out.println("Enter the ISBN of the publication that you want to delete. Enter -1 when you're finished deleting items or 0 if you want to clear the database.");
          option = scnr.nextInt();
          while (option != -1) {
            if (option == 0) {
              System.out.println("Database cleared.");
              database.clear();
            }
            else if (database.containsKey(option)) {
              System.out.println(database.get(option) + " removed.");
              database.remove(option);
            }
            else {
              System.out.println("ISBN does not exist. Please try again.");
            }
            System.out.println("Enter the ISBN of the publication that you want to delete. Enter -1 when you're finished deleting items or 0 if you want to clear the database.");
            option = scnr.nextInt();
          }
        }

        // User decides to exit the database.
        else if (option == 5) {
          exitProgram = true;
        }
      }

      /*
      * Returns the user to the main menu if they enter a number other than
      * (1), (2), (3), (4), or (5).
      */
      catch (InputMismatchException e) {
        System.err.println("Invalid entry. Please try again. Returning to the main menu.");
        String eat = scnr.nextLine();
        continue;
      }
    }
  }
}
