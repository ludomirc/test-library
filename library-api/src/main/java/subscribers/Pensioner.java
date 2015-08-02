package subscribers;

import loans.Loan;
import reporting.OutputServiceContributor;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class Pensioner implements OutputServiceContributor {
    public String id;
    public String name;
    public Map loans = new Hashtable();

    public Pensioner(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pensioner(String name) {
        this.name = name;
    }

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

    public void addLoan(Loan loan) throws Exception {
        if (loans.size() - 1 == getMaxBorrowing()) {
            throw new Exception(name + " has reached their borrowing limit.");
        }
        loan.setSubscriber(this);
        loans.put(loan.getId(), loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan.getId());
    }

    public Collection getLoans() {
        return loans.values();
    }

    public int getMaxBorrowing() {
        return 3;
    }

    public String getFormattedString() {
        return "Pensioner: " + name;
    }
}
