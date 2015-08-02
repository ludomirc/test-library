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

    private static Object lock = new Object();
    private BufferedWriter bufferedWriter = null;
    private static FileOutputService instance = null;

    private FileOutputService(String fileName) throws Exception {
        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
    }

    public static FileOutputService getInstance() throws Exception {
        synchronized (lock) {
            if (instance == null) {
                instance = new FileOutputService("library.log");
            }
        }
        return instance;
    }

    public static FileOutputService getInstance(String fileName) throws Exception {
        synchronized (lock) {
            if (instance == null) {
                instance = new FileOutputService(fileName);
            }
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
        }
    }
}
