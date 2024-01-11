package java8.Consumer;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // consumer
        Consumer<String> con = str -> System.out.println("Hello " + str + ", how are you?");
        Arrays.asList("Ram", "Shyam").forEach(con);

        // consumer chaining
        Consumer<String> cr = con.andThen(s -> System.out.println(s + " is fine."));
        cr.accept("DD");

        BiConsumer<Integer, Integer> biConsumer = (a,b)->System.out.println(a+b);
        biConsumer.accept(5, 7);
    }
}
