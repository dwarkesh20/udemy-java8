package java8.Predicates;

import java.util.Scanner;
import java.util.function.Predicate;

public class Auth {
    public static void main(String[] args) {
        Predicate<User> p = u -> u.getName().equals("DD") && u.getPassword().equals("dd2");
        Scanner sc = new Scanner(System.in);
        User user1 = new User(sc.next(), sc.next());
        System.out.println(p.test(user1) ? "OK" : "FO");
    }
}
