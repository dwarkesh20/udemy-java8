package java8.BiFunction;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, Integer, Student> f = (name, rollno) -> new Student(name, rollno);
        System.out.println(f.apply("John", 101));
    }
}
