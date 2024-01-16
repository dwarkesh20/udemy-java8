package java8.Streams;

import java.util.List;

public class Student {
    private String name;
    private int marks;
    private List<String> subjects;

    public Student(String name, int marks, List<String> subjects) {
        this.name = name;
        this.marks = marks;
        this.subjects = subjects;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

   
    @Override
    public String toString() {
        return "(name=" + name + ", marks=" + marks + ", subjects=" + subjects + ")";
    }
}
