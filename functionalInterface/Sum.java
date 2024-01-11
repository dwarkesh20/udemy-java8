package java8.functionalInterface;

@FunctionalInterface
interface Sum {
    void sum(int a, int b);

    static void m1() {
        System.out.println("m1");
    }
}