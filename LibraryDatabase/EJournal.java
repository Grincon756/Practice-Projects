/*
* Grant Rincon
* Class that represents an EJournal.
*/
public class EJournal extends Journal {
  private String url;
  private int publicationFee;

  // Default
  public EJournal() {
    super();
    url = "";
    publicationFee = 0;
  }
  public EJournal(String title, int year, String publisher, int isbn, String editor, int issueNum,
  String url, int publicationFee) {
    super(title, year, publisher, isbn, editor, issueNum);
    this.url = url;
    this.publicationFee= publicationFee;
  }
  public EJournal(EJournal e) {
    super(e);
    this.url = e.url;
    this.publicationFee = e.publicationFee;
  }
  /*
  * Mutators
  */
  public void setURL(String url) {
    this.url = url;
  }
  public void setPublicationFee(int publicationFee) {
    this.publicationFee = publicationFee;
  }
  /*
  * Accessors
  */
  public String getURL() {
    return url;
  }
  public int getPublicationFee() {
    return publicationFee;
  }
  public String toString() {
    String s = super.toString();
    s += ("URL: " + url + "\n");
    s += ("Publication Fee: $" + publicationFee + ".00\n");
    return s;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EJournal)) {
      return false;
    }
    EJournal j = (EJournal) o;
    return this.title.equals(j.title) && this.yearPublished == j.yearPublished &&
    this.publisher.equals(j.publisher) && this.isbn == j.isbn &&
    this.editor.equals(j.editor) && this.issueNum == j.issueNum &&
    this.url.equals(j.url) && this.publicationFee == j.publicationFee;
  }
}
