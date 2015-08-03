package subscribers;

public class Pensioner extends Subscriber {

    private static final int MAX_BORROWING_LIMIT = 3;

    public Pensioner() {
    }

    public Pensioner(String id, String name) {
        super(id, name);
    }

    public Pensioner(String name) {
        super(name);
    }

    @Override
    public int getMaxBorrowing() {
        return MAX_BORROWING_LIMIT;
    }

    @Override
    public String getFormattedString() {
        return "Pensioner: " + getName();
    }
}
