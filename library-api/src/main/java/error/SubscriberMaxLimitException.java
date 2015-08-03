package error;

/**
 * Created by Benek on 2015-08-03.
 */
public class SubscriberMaxLimitException extends LibraryException {


    /**
     * @param errorReason short generic message describing the error (may not be null)
     * @param cause       a cause of this problem (may be null)
     */
    public SubscriberMaxLimitException(String errorReason, Throwable cause) {
        super(errorReason, cause);
    }

    /**
     * @param errorReason short generic message describing the error (may not be null)
     */
    public SubscriberMaxLimitException(String errorReason) {
        super(errorReason, null);
    }


}
