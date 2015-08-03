package error;

/**
 * Created by Benek on 2015-08-03.
 */
public class LibraryException extends Exception {
    /**
     * @param errorReason short generic message describing the error (may not be null)
     * @param cause       a cause of this problem (may be null)
     */
    public LibraryException(String errorReason, Throwable cause) {
        super(errorReason, cause);
    }
}
