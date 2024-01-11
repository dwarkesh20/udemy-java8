package java8.ConstructRef;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Interf<Sample> i = Sample::new;
        i.get();

        Interf<Date> d = Date::new;
        System.out.println(d.get());

        Interf<String> s = String::new;
        System.out.println(s.get().getBytes());
        System.out.println(s.get().getBytes());
    }
}
