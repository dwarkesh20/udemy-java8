package java8.MethodRef;

public class Main {
    public static void m2() {
        System.out.println("Method Reference Static");
    }

    void m3() {
        System.out.println("Method Reference Instance");
    }

    void run() {
        for (int j = 0; j < 10; j++) {
            System.out.println("child-" + j);
        }
    }

    public static void main(String[] args) {
        Interf i = Main::m2;
        i.m1();

        Main m = new Main();
        Interf lambda = m::m3;
        lambda.m1();

        Runnable r = m::run;
        Thread t = new Thread(r);
        t.start();
        for (int j = 0; j < 10; j++) {
            System.out.println("Main-" + j);
        }
    }
}
