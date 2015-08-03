package subscribers;

public class Student extends Subscriber {

    private String institution;
    private static final int MAX_BORROWING_LIMIT = 6;

    public Student(String id, String name, String institution) {
        super(id, name);
        this.institution = institution;
    }

    public Student(String name, String institution) {
        super(name);
        this.institution = institution;
    }

    @Override
    public int getMaxBorrowing() {
        return MAX_BORROWING_LIMIT;
    }

    @Override
    public String getFormattedString() {
        return "Student: " + name + " - " + institution;
    }
}
