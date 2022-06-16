/*
* Grant Rincon
* Abstract class that provides traits and methods for all publications
* that are compatible with the database.
*/
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class Publication implements Comparable<Publication>, Printable {
  protected String title;
  protected int yearPublished;
  protected String publisher;
  protected int isbn;

  // Default constructor
  public Publication() {
    title = "";
    yearPublished = 0;
    publisher = "";
    isbn = 0;
  }
  public Publication(String title, int year, String publisher, int isbn) {
    this.title = title;
    yearPublished = year;
    this.publisher = publisher;
    this.isbn = isbn;
  }
  public Publication(Publication p) {
    this.title = p.title;
    this.yearPublished = p.yearPublished;
    this.publisher = p.publisher;
    this.isbn = p.isbn;
  }

  /*
  * Mutators
  */
  public void setTitle(String title) {
    this.title = title;
  }
  public void setYearPublished(int year) {
    yearPublished = year;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  public void setISBN(int isbn) {
    this.isbn = isbn;
  }
  /*
  * Accessors
  */
  public String getTitle() {
    return title;
  }
  public int getYearPublished() {
    return yearPublished;
  }
  public String getPublisher() {
    return publisher;
  }
  public int getISBN() {
    return isbn;
  }

  public String toString() {
    String s = "";
    s += ("Title: " + title + "\n");
    s += ("Published in: " + yearPublished + "\n");
    s += ("Published by: " + publisher + "\n");
    s += ("ISBN number: " + isbn + "\n");
    return s;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Publication)) {
      return false;
    }
    Publication p = (Publication) o;
    return this.title.equals(p.title) && this.yearPublished == p.yearPublished &&
    this.publisher.equals(p.publisher) && this.isbn == p.isbn;
  }
  @Override
  public int compareTo(Publication p) {
    if (this.getYearPublished() < p.getYearPublished()) {
      return -1;
    }
    if (this.getYearPublished() > p.getYearPublished()) {
      return 1;
    }
    return 0;
  }
  // Method that prints a publication's information to a .txt file.
  @Override
  public void print(String fileName) {
    FileOutputStream fileStream = null;
    PrintWriter outFS = null;

    try {
      fileStream = new FileOutputStream(fileName);
      outFS = new PrintWriter(fileStream);

      outFS.println(this.toString());
    }
    catch (IOException e) {
      System.err.println("File does not exist.");
    }
    finally {
      if (outFS != null) {
        outFS.close();
      }
    }
  }
}
