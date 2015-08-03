package library;

import error.LoanException;
import error.SubscriberMaxLimitException;
import reporting.ConsoleOutputService;
import reporting.FileOutputService;
import resources.Resource;
import resources.ResourceExtent;
import subscribers.Subscriber;
import subscribers.SubscriberExtent;

import java.util.GregorianCalendar;

public class LibrarySimulator {
    LibraryServicesImpl library;
    LibraryReportingServiceImpl reporting;

    public LibrarySimulator() {
        library = new LibraryServicesImpl();
        reporting = new LibraryReportingServiceImpl();
        reporting.addOutputService(new ConsoleOutputService());
        reporting.addOutputService(new FileOutputService());

    }

    public static void main(String[] args) {
        LibrarySimulator librarySimulator = new LibrarySimulator();
        librarySimulator.runSimulator();
    }

    public void runReports() {
        reporting.outputResourcesReport();
        reporting.outputSubscribersReport();
        reporting.outputOutstandingLoansReport();
    }

    public void runSimulator() {
        // runReports();

        reporting.outputOutstandingLoansReport();
        Resource resource = ResourceExtent.INSTANCE.findByPrimaryKey("R1");
        Subscriber subscriber = SubscriberExtent.INSTANCE.findByPrimaryKey("S1");

        //loan resource
        loadResource(resource, subscriber, new GregorianCalendar(2004, 00, 20));
        reporting.outputOutstandingLoansReport();

        //return resource
        library.returnedResource(resource.getLoan(), new GregorianCalendar(2004, 01, 20));
        reporting.outputOutstandingLoansReport();

        //loan resource
        loadResource(resource, subscriber, new GregorianCalendar(2004, 00, 20));
        reporting.outputOutstandingLoansReport();

        //test max limit
        for (Resource elResource : ResourceExtent.INSTANCE.getResources()) {
            loadResource(elResource, subscriber, new GregorianCalendar(2004, 00, 20));
        }
        reporting.outputOutstandingLoansReport();

    }

    private void loadResource(Resource resource, Subscriber subscriber, GregorianCalendar calendar) {
        try {
            library.loanResourceToSubscriber(resource, subscriber, calendar);
        } catch (LoanException e) {
            System.out.println("Error - Resource can not be loaned");
        } catch (SubscriberMaxLimitException e) {
            System.out.println("Error - Max Limit");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
