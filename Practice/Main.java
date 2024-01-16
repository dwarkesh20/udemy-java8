package java8.Practice;

import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        // switch
        int x = 2;
        int var = switch (x) {
            case 1 -> 1;
            case 2 -> 2;
            default -> 0;
        };
        System.out.println(var);

        // virtual thread example
        ThreadFactory factory = r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        };
        factory.newThread(() -> System.out.println("Hello")).start();
        System.out.println("Done");
      

    }
}
