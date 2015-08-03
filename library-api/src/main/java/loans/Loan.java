package loans;

import reporting.OutputServiceContributor;
import resources.Resource;
import subscribers.Pensioner;
import subscribers.Student;
import subscribers.Subscriber;

import java.util.GregorianCalendar;

public class Loan implements OutputServiceContributor {
    public static int idCounter = 0;
    private Resource resource;
    private Subscriber subscriber;
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
            formattedString += subscriber.getFormattedString();
        } else if (subscriber instanceof Pensioner) {
            formattedString += subscriber.getFormattedString();
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}
