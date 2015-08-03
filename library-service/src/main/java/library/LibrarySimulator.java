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
        try {
            reporting.addOutputService(FileOutputService.getInstance("library.log"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        reporting.outputOutstandingLoansReport();
        Resource resource = ResourceExtent.INSTANCE.findByPrimaryKey("R1");
        Subscriber subscriber = SubscriberExtent.INSTANCE.findByPrimaryKey("S1");

        try {
            library.loanResourceToSubscriber(resource, subscriber, new GregorianCalendar(2004, 00, 20));
        } catch (LoanException e) {
            System.out.println("Error - Resource can not be loaned");
        } catch (SubscriberMaxLimitException e) {
            System.out.println("Error - Max Limit");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        reporting.outputOutstandingLoansReport();
        library.returnedResource(resource.getLoan(), new GregorianCalendar(2004, 00, 20));

        reporting.outputOutstandingLoansReport();
        try {
            library.loanResourceToSubscriber(resource, subscriber, new GregorianCalendar(2004, 00, 20));
        } catch (LoanException e) {
            System.out.println("Error - Resource can not be loaned");
        } catch (SubscriberMaxLimitException e) {
            System.out.println("Error - Max Limit");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        reporting.outputOutstandingLoansReport();


        try {
            FileOutputService.getInstance().closeStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
