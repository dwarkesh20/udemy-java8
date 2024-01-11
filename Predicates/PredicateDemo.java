package java8.Predicates;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        String[] names = { "John", "Alice", "Bob", "Kalu", "Kuma","" };

        Predicate<String> startsWithK = s -> s.length() > 0 && s.charAt(0) == 'K';
        for (String s : names) {
            if (startsWithK.test(s)) {
                System.out.println(s);
            }
        }
        
        BiPredicate<Integer,Integer> bip = (a,b)-> (a+b)%2==0;
        System.out.println(bip.test(10, 20));

        IntPredicate ip = a-> a%2==0;
        System.out.println(ip.test(11));

        
    }
}
