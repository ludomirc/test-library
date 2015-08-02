package library;

import loans.Loan;
import resources.Resource;
import subscribers.Pensioner;
import subscribers.Student;
import subscribers.Subscriber;

import java.util.GregorianCalendar;

/**
 * Created by Benek on 2015-08-02.
 */
public interface LibraryServices {


    public void addResource(Resource resource);

    public void addPensioner(Student student);

    public void addStudent(Pensioner pensioner);

    public void loanResourceToSubscriber(Resource resource, Subscriber subscriber, GregorianCalendar gregorianCalendar) throws Exception;

    public void returnedResource(Loan loan, GregorianCalendar gregorianCalendar);

}
