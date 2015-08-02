package library;

import reporting.OutputService;

/**
 * Created by Benek on 2015-08-02.
 */
public interface LibraryReportingService {

    public void outputSubscribersReport();

    public void outputResourcesReport();

    public void outputOutstandingLoansReport();

    public void addOutputService(OutputService outputService);

    public void removeOutputService(OutputService outputService);


}
