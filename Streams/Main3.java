package java8.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

public class Main3 {
        public static void main(String[] args) {
                List<Student> students = new ArrayList<>();
                populateStudens(students);
                students.forEach(System.out::println);
                // streams joining student name\
                System.out.println("Joining student names");
                students.stream().map(Student::getName).forEach(System.out::println);
                String joinedNames = students.stream()
                                .map(Student::getName)
                                .collect(joining(", ", "->", "."));
                System.out.println(joinedNames);

                // couting
                long count = students.stream().count();
                System.out.println("Count of Students: " + count);

                // maxby
                Student maxByMarks = students.stream()
                                // .collect(maxBy(Comparator.comparing(Student::getMarks))).get();
                                .reduce(BinaryOperator.maxBy((Comparator.comparing(Student::getMarks)))).get();
                System.out.println("maxBy Marks Student: " + maxByMarks);

                // summing subjects
                long sumOfSubjects = students.stream()
                                .flatMap(student -> student.getSubjects().stream())
                                .distinct()
                                .count();
                System.out.println("Sum of Subjects: " + sumOfSubjects);

                // grouping by subject and counting marks
                System.out.println("\nGrouping by subject and counting marks:\nCategory \t Names");
                students.stream()
                                .collect(Collectors.groupingBy(s -> s.getMarks() > 80 ? "GOOD" : "BAD"))
                                .forEach((k, v) -> {
                                        System.out.println(
                                                        k + v.stream().map(Student::getName)
                                                                        .collect(joining(",", "\t->\t", "")));
                                });

                // groupingby marks
                System.out.println("\nGrouping by marks:\nName \t Count");
                Map<Integer, List<Student>> collect = students.stream()
                                .collect(Collectors.groupingBy(Student::getMarks));
                collect.forEach((k, v) -> {
                        System.out.println(
                                        k + v.stream().map(Student::getName).collect(joining(",", " -> ", "")));
                });
                // subject grouping by name subject->[names]
                System.out.println("\nSubject grouping by name subject->[names]");
                Map<List<String>, List<Student>> collect1 = students.stream()
                                // flatMap
                                .flatMap(student -> student.getSubjects().stream()
                                                .map(subject -> new Student(student.getName(), student.getMarks(),
                                                                List.of(subject))))
                                .collect(Collectors.groupingBy(Student::getSubjects));

                collect1.forEach((k, v) -> {
                        System.out.println(
                                        k.get(0) + v.stream().map(Student::getName).collect(joining(",", " -> ", "")));
                });

                // name and count of subjects
                System.out.println("\nName \t count of subjects");
                students.stream()
                                .collect(Collectors.groupingBy(Student::getName,
                                                Collectors.summingInt(value -> value.getSubjects().size())))
                                .forEach((k, v) -> System.out.println(k + "\t->\t" + v));

                // partitioningby
                System.out.println("\nPartitioningby");
                Map<Boolean, Set<Student>> collectmMap = students.stream()
                                .collect(Collectors.partitioningBy(s -> s.getMarks() > 80, toSet()));
                collectmMap.forEach((k, v) -> {
                        System.out.println(k + v.stream().map(Student::getName).collect(joining(",")));
                });
        }

        private static void populateStudens(List<Student> students) {
                students.add(new Student("DD", 99, List.of("Gujarati", "Maths", "Science")));
                students.add(new Student("CC", 90, List.of("English", "Hindi")));
                students.add(new Student("DV", 88, List.of("SS", "Maths", "Hindi")));
                students.add(new Student("John", 77, List.of("English", "SS")));
                students.add(new Student("Jane", 57, List.of("Science", "Maths")));
                students.add(new Student("Tom", 77, List.of("Hindi", "Science")));
        }

}
