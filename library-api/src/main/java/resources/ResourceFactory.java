package resources;

/**
 * Created by Benek on 2015-08-02.
 */
public class ResourceFactory {

    public static final String RESOURCE_TYPE_BOOK = "Book";

    public static Resource getResourceInstance(String type, String title, String extra) {
        if (type.equals(RESOURCE_TYPE_BOOK)) {
            return new BookResource(title, type, extra);
        } else {
            return new GameResource(title, type, extra);
        }
    }
}
