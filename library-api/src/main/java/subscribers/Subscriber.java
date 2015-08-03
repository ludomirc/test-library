package subscribers;

import error.SubscriberMaxLimitException;
import loans.Loan;
import reporting.OutputServiceContributor;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Benek on 2015-08-02.
 */
public abstract class Subscriber implements OutputServiceContributor, Serializable {

    protected String id;
    protected String name;
    protected Map<String, Loan> loans = new Hashtable<String, Loan>();

    public Subscriber() {
    }

    public Subscriber(String name) {
        this.name = name;
    }

    public Subscriber(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subscriber(String id, String name, Map<String, Loan> loans) {
        this.id = id;
        this.name = name;
        this.loans = loans;
    }

    public abstract int getMaxBorrowing();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Loan> getLoans() {
        return loans;
    }

    public void setLoans(Map<String, Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan loan) throws Exception {
        if (loans.size() - 1 == getMaxBorrowing()) {
            throw new SubscriberMaxLimitException(name + " has reached their borrowing limit.");
        }
        loan.setSubscriber(this);
        loans.put(loan.getId(), loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan.getId());
    }
}
