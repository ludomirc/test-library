package loans;

import reporting.OutputServiceContributor;
import resources.AbstractResource;
import subscribers.Pensioner;
import subscribers.Student;

import java.util.GregorianCalendar;

public class Loan implements OutputServiceContributor {
    public static int idCounter = 0;
    private AbstractResource resource;
    private Object subscriber;
    private GregorianCalendar loanDate;
    private GregorianCalendar returnDate;
    private String id;

    public Loan() {
        this.id = "L" + idCounter++;
    }

    public Loan(String id) {
        this.id = id;
        idCounter++;
    }

    public String getFormattedString() {
        String formattedString = (resource == null ? "Unknown" : resource.getFormattedString()) + " loaned to ";
        if (subscriber == null) {
            formattedString += "Nobody";
        } else if (subscriber instanceof Student) {
            formattedString += ((Student) subscriber).getFormattedString();
        } else if (subscriber instanceof Pensioner) {
            formattedString += ((Pensioner) subscriber).getFormattedString();
        } else {
            formattedString += "Unknown subscriber type.";
        }
        return formattedString;
    }

    public GregorianCalendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(GregorianCalendar returnDate) {
        if (this.returnDate != null)
            throw new IllegalStateException("Return date has already been assigned");
        if (subscriber instanceof Student) {
            ((Student) subscriber).removeLoan(this);
        } else if (subscriber instanceof Pensioner) {
            ((Pensioner) subscriber).removeLoan(this);
        }
        resource.removeLoan();
        this.returnDate = returnDate;
    }

    public String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    public GregorianCalendar getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(GregorianCalendar loanDate) {
        this.loanDate = loanDate;
    }

    public AbstractResource getResource() {
        return resource;
    }

    public void setResource(AbstractResource resource) {
        this.resource = resource;
    }

    public Object getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Object subscriber) {
        this.subscriber = subscriber;
    }
}
