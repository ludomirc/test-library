package library;

import loans.Loan;
import resources.AbstractResource;
import subscribers.Pensioner;
import subscribers.Student;

import java.util.GregorianCalendar;

/**
 * Created by Benek on 2015-08-02.
 */
public interface LibraryServices {


    public void addResource(AbstractResource resource);

    public void addPensioner(Student student);

    public void addStudent(Pensioner pensioner);

    public void loanResourceToSubscriber(AbstractResource resource, Object subscriber, GregorianCalendar gregorianCalendar) throws Exception;

    public void returnedResource(Loan loan, GregorianCalendar gregorianCalendar);

}
