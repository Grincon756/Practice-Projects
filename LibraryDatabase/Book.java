/*
* Grant Rincon
* Class that represents a book and contains its author, page count, and binding type.
*/
public class Book extends Publication {
  private String author;
  private int pageCount;
  private String bindingType;

  public Book() {
    super();
    author = "";
    pageCount = 0;
    bindingType = "";
  }
  public Book(String title, int year, String publisher, int isbn, String author, int pageCount, String bindingType) {
    super(title, year, publisher, isbn);
    this.author = author;
    this.pageCount = pageCount;
    this.bindingType = bindingType;
  }
  public Book(Book libro) {
    super(libro);
    this.author = libro.author;
    this.pageCount = libro.pageCount;
    this.bindingType = bindingType;
  }
  /*
  * Mutators
  */
  public void setAuthor(String author) {
    this.author = author;
  }
  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }
  public void setBindingType(String binding) {
    bindingType = binding;
  }
  /*
  * Accessors
  */
  public String getAuthor() {
    return author;
  }
  public int getPageCount() {
    return pageCount;
  }
  public String getBindingType() {
    return bindingType;
  }
  public String toString() {
    String s = super.toString();
    s += ("Written by: " + author + "\n");
    s += ("Page count: " + pageCount + "\n");
    s += (bindingType + "\n");
    return s;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    Book b = (Book) o;
    return this.title.equals(b.title) && this.author.equals(b.author) && this.yearPublished == b.yearPublished &&
    this.publisher.equals(b.publisher) && this.isbn == b.isbn && this.pageCount == b.pageCount && this.bindingType.equals(b.bindingType);
  }
}
