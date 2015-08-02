package reporting;

import java.util.Collection;
import java.util.Iterator;

public class ConsoleOutputService implements OutputService {
    public ConsoleOutputService() {
    }

    public void outputExtent(String title, Collection<OutputServiceContributor> subscribers) throws Exception {
        System.out.println("\n" + title + "\n-----------");
        OutputServiceContributor subscriber;
        for (Iterator<OutputServiceContributor> iter = subscribers.iterator(); iter.hasNext(); ) {
            subscriber = iter.next();
            System.out.println(subscriber.getFormattedString());
        }
    }

    public String getName() {
        return "Console output service";
    }
}
