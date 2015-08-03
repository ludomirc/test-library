package error;

/**
 * Created by Benek on 2015-08-03.
 */
public class LoanException extends LibraryException {

    public LoanException(String errorReason, Throwable cause) {
        super(errorReason, cause);
    }

    public LoanException(String errorReason) {
        super(errorReason, null);
    }

}
