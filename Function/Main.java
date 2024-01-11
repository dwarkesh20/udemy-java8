package java8.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("DD"));

        Function<String, Integer> removeSpace = s -> s.length() - s.replaceAll(" ", "").length();
        System.out.println(removeSpace.apply("Dwar kesh  Dham echa "));

        List<Student> students = new ArrayList<>();
        populateStudens(students);
        System.out.println(students);

        Function<Student, String> getGrades = s -> {
            int marks = s.getMarks();
            if (marks > 80) {
                return "A";
            } else if (marks > 60 && marks <= 80) {
                return "B";
            } else {
                return "C";
            }
        };
        students.forEach((s) -> System.out.println(s.getName() + "->" + getGrades.apply(s)));
        // predicate for marks>60
        Predicate<Student> predi = s -> s.getMarks() > 80;
        System.out.println("\nStudents with Marks>80");
        students.forEach(s -> {
            if (predi.test(s))
                System.out.println(s.getName() + "->" + getGrades.apply(s));
        });

        List<Employee> employees = new ArrayList<>();
        populateEmp(employees);

        System.out.println("Employees who are eligible for promotion: ");
        employees.stream().filter(e -> e.getSalary() > 50000).map(Employee::getName).forEach(System.out::println);

        // get totle sum of all employee using strem function
        double totalSalary = employees.stream().mapToDouble(emp -> emp.getSalary())
                .reduce(0L, Double::sum);
        System.out.println("Total salary=" + totalSalary);

        // function chaining
        Function<Integer, Integer> sum = i -> i + i;
        Function<Integer, Integer> mul = i -> i * i;
        System.out.println("Sum then Mul: " + sum.andThen(mul).apply(3));
        System.out.println("Mul then Sum: " + sum.compose(mul).apply(3));


        BiFunction<Integer, Integer, Integer> biFn = (a,b) -> a*b;
        System.out.println(biFn.apply(20, 92));
    }

    private static void populateStudens(List<Student> students) {
        students.add(new Student("DD", 90));
        students.add(new Student("DV", 88));
        students.add(new Student("John", 79));
        students.add(new Student("Jane", 57));
        students.add(new Student("Tom", 77));
    }

    private static void populateEmp(List<Employee> list) {
        list.add(new Employee("Dwarkesh", 30000));
        list.add(new Employee("Saurabh", 70000));
        list.add(new Employee("Rahul", 50000));
        list.add(new Employee("Ronak", 55000));
        list.add(new Employee("Ajay", 200000));
        list.add(new Employee("Vijay", 60000));

    }
}
