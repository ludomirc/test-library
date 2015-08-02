package subscribers;

public class Student extends Subscriber {

    public String institution;

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
        return 6;
    }

    @Override
    public String getFormattedString() {
        return "Student: " + name + " - " + institution;
    }
}
