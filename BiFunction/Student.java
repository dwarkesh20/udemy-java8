package java8.BiFunction;

public class Student {
    private String name;
    private int rollno;

    public Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "(Name=" + name + ", rollno= " + rollno + ")";
    }
}
