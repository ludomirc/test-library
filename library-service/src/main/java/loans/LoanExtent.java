/*
 * Created on 02-Feb-2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package loans;

import resources.Resource;
import resources.ResourceExtent;
import subscribers.Pensioner;
import subscribers.Student;
import subscribers.SubscriberExtent;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map;

public class LoanExtent {

    private static Map<String, Loan> loans = new Hashtable<String, Loan>();
    private static int idCounter = 0;
    public static LoanExtent INSTANCE = new LoanExtent();

    private LoanExtent() {
        try {
            //Initialise and register resources currently on loan
            createLoan(ResourceExtent.INSTANCE.findByPrimaryKey("R1"), SubscriberExtent.INSTANCE.findByPrimaryKey("S3"), new GregorianCalendar(2004, 00, 20));
            createLoan(ResourceExtent.INSTANCE.findByPrimaryKey("R5"), SubscriberExtent.INSTANCE.findByPrimaryKey("S3"), new GregorianCalendar(2004, 00, 01));
            createLoan(ResourceExtent.INSTANCE.findByPrimaryKey("R4"), SubscriberExtent.INSTANCE.findByPrimaryKey("S1"), new GregorianCalendar(2004, 00, 01));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loan createLoan(Resource resource, Object subscriber, GregorianCalendar gregorianCalendar) throws Exception {
        if (resource == null) {
            throw new NullPointerException("Resource parameter can not be null");
        }
        if (subscriber == null) {
            throw new NullPointerException("Subscriber parameter can not be null");
        }
        Loan loan = new Loan();
        resource.setLoan(loan);
        if (subscriber instanceof Student) {
            ((Student) subscriber).addLoan(loan);
        } else if (subscriber instanceof Pensioner) {
            ((Pensioner) subscriber).addLoan(loan);
        }
        loan.setResource(resource);
        loan.setSubscriber(subscriber);
        loan.setLoanDate(gregorianCalendar);
        loan.setId(getNextId());
        loans.put(loan.getId(), loan);
        return loan;
    }

    public Loan findByPrimaryKey(String id) {
        return loans.get(id);
    }

    public Collection<Loan> getLoans() {
        return loans.values();
    }

    public String getNextId() {
        return "L" + (idCounter++);
    }
}
