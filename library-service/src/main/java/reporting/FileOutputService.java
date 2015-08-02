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

    public static final String DEFAULT_FILE_NAME = "library.log";
    private BufferedWriter bufferedWriter = null;
    private static FileOutputService instance = null;

    private FileOutputService(String fileName) throws Exception {
        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
    }

    public static FileOutputService getInstance() throws Exception {
        if (instance == null) {
            instance = new FileOutputService(DEFAULT_FILE_NAME);
        }
        return instance;
    }

    public static FileOutputService getInstance(String fileName) throws Exception {

        if (instance == null) {
            instance = new FileOutputService(fileName);
        }

        return instance;
    }

    @Override
    public void outputExtent(String title, Collection<OutputServiceContributor> subscribers) throws Exception {
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
            instance = null;
        }
    }
}
