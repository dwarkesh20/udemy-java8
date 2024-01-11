package java8.Supplier;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Date> s = () -> new Date();
        System.out.println("Today's date is " + s.get());

        Supplier<String> random = () -> {
            // random string
            String randStr = "";
            for (int i = 0; i < 10; i++)
                randStr += (char) (int) (Math.random() * 100);
            return randStr;
        };
        System.out.println(random.get());

        // random otp Supplier
        Supplier<Integer> printOtp = () -> ((int) Math.floor(Math.random() * 10));
        Consumer<Integer> showOtp = x -> System.out.println("Your OTP is :" + x);
        showOtp.accept(printOtp.get());


      



    }
}