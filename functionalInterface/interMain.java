package java8.functionalInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public interface interMain {

    static void main(String[] args) {
        System.out.println("Hello World!");
        Predicate<Integer> p1 = i -> i > 10;
        Predicate<Integer> p2 = i -> i % 2 == 0;
        Predicate<Integer> p3 = p1.and(p2);
        Predicate<Integer> p4 = p1.or(p2);

        System.out.println("p1: "+p1.test(22));
        System.out.println("p2: "+p2.test(23));
        System.out.println("p3: "+p3.test(23));
        System.out.println("p4: "+p4.test(23));


        Predicate<Collection<Integer>> p = c -> c.isEmpty();
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(p.test(list)); // true
        list.add(3);
        System.out.println(p.test(list));// false

    }
}