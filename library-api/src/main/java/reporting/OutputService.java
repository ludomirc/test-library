package reporting;

import java.util.Collection;

public interface OutputService {
    public void outputExtent(String title, Collection<OutputServiceContributor> subscribers) throws Exception;

    public String getName();
}
