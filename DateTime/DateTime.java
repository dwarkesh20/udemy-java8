package java8.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTime {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();

        System.out.println("Current Date Time: " + dt);
        // Get year, month and day of the date time
        int year = dt.getYear();
        int month = dt.getMonthValue();
        int day = dt.getDayOfMonth();
        System.out.printf("\n Year: %d\n Month: %d\n Day: %d", year, month, day);
        // Get hour, minute and second of the date time
        int hour = dt.getHour();
        int min = dt.getMinute();
        int sec = dt.getSecond();
        System.out.printf("\n Hour: %02d : Minute: %02d : Second: %02d ", hour, min, sec);

        // of
        LocalDateTime dt1 = LocalDateTime.of(2023, 9, 25, 14, 30, 0);
        System.out.println("\nDate & Time provided by user");
        System.out.println(dt1);

        // period
        LocalDate today = LocalDate.now();
        LocalDate birthdate = LocalDate.of(2002, 7,
                1);
        Period p = Period.between(birthdate, today);
        System.out.printf("\nYour Age is %d Years %d Months and %d Days old",
                p.getYears(), p.getMonths(), p.getDays());

        Year y = Year.now();
        System.out.println("\nCurrent Year " + y);
        System.out.println("Is Leap? " + (y.isLeap() ? "yes" : "no"));

        //zodeid
        ZoneId zone = ZoneId.systemDefault();
        System.out.println("\nMy timezone is " + zone);

        ZoneId z = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zdt = ZonedDateTime.now(z);
        System.out.println("\nTime in LA is " + zdt.toLocalTime());
        

    }
}
