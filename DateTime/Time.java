package java8.DateTime;

import java.time.LocalTime;

public class Time {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        
        System.out.println("Current Time: " + time);
        // Get Hour
        int hour = time.getHour();
        System.out.println("Hour: " + hour);
        // Get Minute
        int minute = time.getMinute();
        System.out.println("Minute: " + minute);
        // Get Second
        int second = time.getSecond();
        System.out.println("Second: " + second);
        
    }
}
