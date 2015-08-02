package library;

import loans.Loan;
import loans.LoanExtent;
import resources.Resource;
import resources.ResourceExtent;
import subscribers.Pensioner;
import subscribers.Student;
import subscribers.SubscriberExtent;

import java.util.GregorianCalendar;

public class LibraryServices {

    public LibraryServices() {
    }

    public void addResource(Resource resource) {
        ResourceExtent.INSTANCE.createResource(resource);
    }

    public void addPensioner(Student student) {
        SubscriberExtent.INSTANCE.createStudent(student);
    }

    public void addStudent(Pensioner pensioner) {
        SubscriberExtent.INSTANCE.createPensioner(pensioner);
    }

    public void loanResourceToSubscriber(Resource resource, Object subscriber, GregorianCalendar gregorianCalendar) throws Exception {
        LoanExtent.INSTANCE.createLoan(resource, subscriber, gregorianCalendar);
    }

    public void returnedResource(Loan loan, GregorianCalendar gregorianCalendar) {
        if (loan != null) {
            loan.setReturnDate(gregorianCalendar);
        }
    }

}
