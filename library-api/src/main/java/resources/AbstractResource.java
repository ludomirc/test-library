package resources;

import loans.Loan;
import reporting.OutputServiceContributor;

import java.io.Serializable;

/**
 * Created by Benek on 2015-08-02.
 */

public abstract class AbstractResource implements OutputServiceContributor, Serializable{

    public String id;
    public String title;
    public String type;
    public String author;
    public Loan loan;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
