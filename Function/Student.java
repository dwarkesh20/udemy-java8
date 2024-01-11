package java8.Function;

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "(Name=" + name + ", Marks= " + marks + ")";
    }
}
