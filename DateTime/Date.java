package java8.DateTime;

import java.time.LocalDate;
import java.time.LocalTime;

public class Date {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("Today's Date: " + date);
        LocalTime localTime = LocalTime.now();
        System.out.println("Current Time: " + localTime);

        //dd
        int day = date.getDayOfMonth();
        System.out.println("\nToday's Day of Month: " + day+ "\nDay of Week (Monday=1, Sunday=7): " +date.getDayOfWeek().getValue());
        
        //mm
        int month = date.getMonthValue();
        String monthName = date.getMonth().toString();
        System.out.println("This Month Number: " + month+ "\nThis Month Name: " + monthName);
        
        //yyyy
        int year = date.getYear();
        System.out.println("This Year: " + year);
        System.out.format("\nDate: %d/%d/%d", day,month,year);
        //Getting the date from a string in dd/MM/yy format
        String strDate = "25/09/2024";
        LocalDate newDate = LocalDate.parse(strDate,java.time.format.DateTimeFormatter.ofPattern("d/M/y"));
        System.out.println("\nGiven Date: " + strDate +
        "\nParsed Date: " + newDate);

    }
}
