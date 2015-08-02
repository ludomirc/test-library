package resources;

import loans.Loan;

/**
 * Created by Benek on 2015-08-02.
 */
public class BookResource extends AbstractResource {

    private String author;

    public BookResource() {
    }

    public BookResource(String title, String type, String author) {
        super(title, type);
        this.author = author;
    }

    public BookResource(String id, String title, String type, String author, Loan loan) {
        super(id, title, type, loan);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getFormattedString() {
        return "Book - " + getTitle() + " by " + author;
    }
}
