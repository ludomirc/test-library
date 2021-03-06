package resources;

import error.LoanException;
import loans.Loan;
import reporting.OutputServiceContributor;

import java.io.Serializable;

/**
 * Created by Benek on 2015-08-02.
 */

public abstract class Resource implements OutputServiceContributor, Serializable {

    protected String id;
    protected String title;
    protected String type;
    protected Loan loan;

    private static final int MAX_LOAN_PERIOD = 28;
    private static final double SURCHARGE = 0;

    public Resource() {
    }

    public Resource(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public Resource(String title, String type, Loan loan) {
        this.title = title;
        this.type = type;
        this.loan = loan;
    }

    public Resource(String id, String title, String type, Loan loan) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.loan = loan;
    }

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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) throws Exception {
        if (this.loan != null) {
            throw new LoanException("This resource is already on loan: " + this.loan.getFormattedString());
        }
        this.loan = loan;
    }

    public void removeLoan() {
        loan = null;
    }

    public int getMaxLoanPeriod() {
        return MAX_LOAN_PERIOD;
    }

    public double getSurcharge() {
        return SURCHARGE;
    }

}
