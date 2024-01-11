package java8.functionalInterface;

public class interfaceDemo implements Sum {
    public static void main(String[] args) {
        Sum s = (a, b) -> System.out.println("sum is: " + a + b);
        s.sum(1, 3);
        s.sum(4, 9);

        // lambda expression can be used to implement functional interfaces that have
        // only one abstract method.
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread-" + i);
            }
        };
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main-" + i);
        }

        Sum.m1();
        interfaceDemo a = new interfaceDemo();
        a.sum(1, 2);
    }

    @Override
    public void sum(int a, int b) {
        System.out.println("Sum of two numbers : " + (a + b));
    }

}