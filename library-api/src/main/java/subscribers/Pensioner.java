package subscribers;

public class Pensioner extends Subscriber {

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
        return 3;
    }

    @Override
    public String getFormattedString() {
        return "Pensioner: " + getName();
    }
}
