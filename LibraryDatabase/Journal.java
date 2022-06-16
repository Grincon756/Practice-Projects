/*
* Grant Rincon
* Class that represents a Journal.
*/

public class Journal extends Publication {
  protected String editor;
  protected int issueNum;

  public Journal() {
    super();
    editor = "";
    issueNum = 0;
  }
  public Journal(String title, int year, String publisher, int isbn, String editor, int issueNum) {
    super(title, year, publisher, isbn);
    this.editor = editor;
    this.issueNum = issueNum;
  }
  public Journal(Journal j) {
    super(j);
    this.editor = j.editor;
    this.issueNum = j.issueNum;
  }
  public void setEditor(String editor) {
    this.editor = editor;
  }
  public void setIssueNum(int issueNum) {
    this.issueNum = issueNum;
  }
  public String getEditor() {
    return editor;
  }
  public int getIssueNum() {
    return issueNum;
  }
  public String toString() {
    String s = super.toString();
    s += ("Editor: " + editor + "\n");
    s += ("Issue Number: " + issueNum + "\n");

    return s;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Journal)) {
      return false;
    }
    Journal j = (Journal) o;
    return this.title.equals(j.title) && this.yearPublished == j.yearPublished &&
    this.publisher.equals(j.publisher) && this.isbn == j.isbn &&
    this.editor.equals(j.editor) && this.issueNum == j.issueNum;
  }
}
