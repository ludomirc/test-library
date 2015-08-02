/*
 * Created on 02-Feb-2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package library;

import loans.Loan;
import loans.LoanExtent;
import reporting.OutputService;
import reporting.OutputServiceContributor;
import resources.ResourceExtent;
import subscribers.SubscriberExtent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author Simon
 *         <p>
 *         To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Generation - Code and Comments
 */
public class LibraryReportingServiceImpl implements LibraryReportingService{
    Collection<OutputService> outputServices = new Vector<OutputService>();

    public void outputSubscribersReport() {
        OutputService outputService;
        for (Iterator<OutputService> iter = outputServices.iterator(); iter.hasNext(); ) {
            outputService = iter.next();
            try {
                outputService.outputExtent("Subscribers", new ArrayList<OutputServiceContributor>(SubscriberExtent.INSTANCE.getSubscribers()));
            } catch (Exception e) {
                System.out.println("Exception while outputing subscriber to service " + outputService.getName() + " - Original message: " + e.getMessage());
            }
        }
    }

    /**
     * Generates a report on resources using the registered output services
     */
    public void outputResourcesReport() {
        OutputService outputService = null;
        for (Iterator<OutputService> iter = outputServices.iterator(); iter.hasNext(); ) {
            outputService = iter.next();
            try {
                outputService.outputExtent("Resources", new ArrayList<OutputServiceContributor>(ResourceExtent.INSTANCE.getResources()));
            } catch (Exception e) {
                System.out.println("Exception while outputing resource to service " + outputService.getName() + " - Original message: " + e.getMessage());
            }
        }
    }

    public void outputOutstandingLoansReport() {
        OutputService outputService = null;
        Collection<Loan> loans = LoanExtent.INSTANCE.getLoans();
        Collection<Loan> outstandingLoans = new Vector<Loan>();
        for (Iterator<Loan> iter = loans.iterator(); iter.hasNext(); ) {
            Loan element = iter.next();
            if (element.getReturnDate() == null) {
                outstandingLoans.add(element);
            }
        }
        for (Iterator<OutputService> iter = outputServices.iterator(); iter.hasNext(); ) {
            outputService = iter.next();
            try {
                outputService.outputExtent("Loans", new ArrayList<OutputServiceContributor>(outstandingLoans));
            } catch (Exception e) {
                System.out.println("Exception while outputing loan to service " + outputService.getName() + " - Original message: " + e.getMessage());
            }
        }
    }

    public void addOutputService(OutputService outputService) {
        outputServices.add(outputService);
    }

    public void removeOutputService(OutputService outputService) {
        outputServices.remove(outputService);
    }


}
