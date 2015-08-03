package reporting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Benek on 2015-08-02.
 */
public class FileOutputService implements OutputService {

    private static final String DEFAULT_LOG_FILENAME = "defaultLibraryLog.log";
    private BufferedWriter bufferedWriter = null;
    private String fileName = null;

    public FileOutputService(String fileName) {
        this.fileName = fileName;
    }

    public FileOutputService() {
        this(DEFAULT_LOG_FILENAME);
    }

    ;

    @Override
    public void outputExtent(String title, Collection<OutputServiceContributor> subscribers) throws Exception {
        if (bufferedWriter == null) {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        }

        bufferedWriter.write("\n" + title + "\n-----------");
        bufferedWriter.newLine();

        OutputServiceContributor outputServiceContributor;
        for (Iterator<OutputServiceContributor> iter = subscribers.iterator(); iter.hasNext(); ) {
            outputServiceContributor = iter.next();
            bufferedWriter.write(outputServiceContributor.getFormattedString());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

    @Override
    public String getName() {
        return "File output service";
    }

    public void closeStream() throws IOException {
        if (bufferedWriter != null) {
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }
}
