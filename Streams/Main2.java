package java8.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;

public class Main2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        populateStudens(students);
        students.forEach(System.out::println);
        // flatMap - used to flatten the stream of streams into a single stream
        List<String> sub = students.stream()
                .map(Student::getSubjects)
                .flatMap(List::stream)
                .toList();
        System.out.println(sub);

        List<String> subdist = students.stream()
                .map(Student::getSubjects)
                .flatMap(List::stream)
                .distinct()
                .sorted((a, b) -> b.compareTo(a))
                .toList();
        System.out.println("Distinct and sorted: " + subdist);

        // sort by name
        System.out.println("\nSort by name");
        List<Student> sortByName = students.stream().sorted(Comparator.comparing(Student::getName)).toList();
        sortByName.forEach(System.out::println);

        // sort by marks
        System.out.println("\nSort by marks");
        List<Student> sortByMarks = students.stream().sorted(Comparator.comparing(Student::getMarks)).toList();
        sortByMarks.forEach(System.out::println);

        // filter
        System.out.println("\nFilter by marks >80");
        List<Student> filterByMarks = students.stream().filter(s -> s.getMarks() > 80).toList();
        filterByMarks.forEach(System.out::println);

        // filter by subject>2
        System.out.println("\nFilter by subject>2");
        List<Student> filterBySubject = students.stream().filter(s -> s.getSubjects().size() > 2).toList();
        filterBySubject.forEach(System.out::println);

        // reduce
        System.out.println("\nReduce");
        Integer reduce = students.stream().mapToInt(Student::getMarks).reduce(Integer::sum).getAsInt();
        System.out.println(reduce);

        // reduce multiplication from 1 to n
        System.out.println("\nMultiplication using reduce");
        Integer fact = IntStream.range(1, 10)
                .reduce(1, (a, b) -> a * b);
        System.out.print(fact);

        // heighest marks student
        Student highestMarks = students.stream().max(Comparator.comparing(Student::getMarks)).get();
        System.out.println("\nHighest marks student: " + highestMarks);

        // heighest marks student using reduce
        OptionalInt max = students.stream().mapToInt(Student::getMarks).max();
        System.out.println("Highest marks student using reduce: " + max.getAsInt());

        // allmatch
        System.out.println("\nAll match");
        boolean allMatch = students.stream().anyMatch(s -> s.getMarks() > 80);
        System.out.println(allMatch);

        // findany
        System.out.println("\nFind any");
        Student findAny = students.stream().filter(s -> s.getMarks() > 66).findAny().get();
        System.out.println(findAny);
        // findfirst
        System.out.println("\nFind first");
        Student findFirst = students.stream().filter(s -> s.getName().startsWith("J")).findFirst().get();
        System.out.println(findFirst);

        // of
        System.out.println("\nOf");
        List<String> list = Stream.of("Java", "Python", "C++").map(String::toUpperCase).toList();
        System.out.println(list);

        // iterate
        System.out.println("\nIterate");
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);

        // generator
        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);

        // numeric stream
        System.out.println("\nNumeric streams");
        int isum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum of numbers from 1 to 10 is :" + isum);
        long lsum = LongStream.range(1L, 10L).sum();
        System.out.println("Sum of numbers from 1 to 9 is :" + lsum);

        // avg
        double dblAvg = DoubleStream.builder()
                .add(4.2)
                .add(3.5)
                .add(5.6)
                .add(7.8)
                .build()
                .average()
                .getAsDouble();
        System.out.println("Average of numbers is :" + dblAvg);

        // boxing
        Integer[] integerArray = { 1, 2, 3 };
        System.out.println(Arrays.stream(integerArray).toList());

        // maptoobj
        String[] stringArray = { "I am a java developer", "I love coding", "I enjoy solving problems" };
        List<String> words = Arrays.stream(stringArray)
                .flatMap(w -> Arrays.stream(w.split("\\s+")))
                .toList();
        System.out.println(words);

        // maptolong
        List<Long> numberList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<Long> squareNumberList = numberList.stream().mapToLong(x -> x * x).boxed().toList();
        System.out.println(squareNumberList);

    }

    private static void populateStudens(List<Student> students) {
        students.add(new Student("DD", 99, List.of("Gujarati", "Maths", "Science")));
        students.add(new Student("CC", 90, List.of("English", "Hindi")));
        students.add(new Student("DV", 88, List.of("SS", "Maths", "Hindi")));
        students.add(new Student("John", 79, List.of("English", "SS")));
        students.add(new Student("Jane", 57, List.of("Science", "Maths")));
        students.add(new Student("Tom", 77, List.of("Hindi", "Science")));
    }

}
