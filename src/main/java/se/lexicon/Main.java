package se.lexicon;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    static void main() {
        // Exercise 1 – Current Date
        currentDate();
        System.out.println();
        // Exercise 2 – Formatted Current Date
        formattedDate();
        System.out.println();
        // Exercise 3 – Last Monday and the Entire Week
        lastMondayWeek();
        System.out.println();
        // Exercise 4 – Parse Date from String
        parseDate("2023-12-25");
        System.out.println();
        // Exercise 5 – Day of the Week
        dayOfTheWeek(1988,7,2);
        System.out.println();
        // Exercise 6 – Future and Past Date
        futurePastDate();
        System.out.println();



    }
    //Create a LocalDate of the current day and print it out.
    public static void currentDate(){
        LocalDate date = LocalDate.now();
        System.out.println(date);
    }

    //Create a LocalDate of the current day and print it out in the following pattern using DateTimeFormatter: Torsdag 29 mars.
    public static void formattedDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("eeee dd MMMM");
        LocalDate date = LocalDate.now();
        System.out.println(date.format(formatter));
    }

    //Create a LocalDate of last Monday. Then print out the entire week in a loop using standard ISO format.
    public static void lastMondayWeek(){
        LocalDate lastMonday = LocalDate.now().minusDays(1);
        System.out.println("Last Monday: "+lastMonday);
        for (int i=0; i<7; i++) {
            System.out.println(lastMonday.plusDays(i) + " " +lastMonday.plusDays(i).getDayOfWeek() );
        }
    }

    //Create a LocalDate object from a String by using the .parse() method.
    public static void parseDate(String date){
        LocalDate parsedDate = LocalDate.parse(date);
        System.out.println("Parsed Date: " + parsedDate);
    }

    //The date time API provides enums for time units such as day and month. Create a LocalDate of your birthday and extract the day of week for that date.
    //Example: 1945-05-08 -> TUESDAY

    public static void dayOfTheWeek(int yyyy, int mm, int dd){
        LocalDate givenDate = LocalDate.of(yyyy, mm, dd);
        DayOfWeek day = givenDate.getDayOfWeek();
        System.out.println(givenDate +" " + day);
    }

    //Create a LocalDate of current date plus 10 years and minus 10 months. From that date extract the month and print it out.
    public static void futurePastDate(){
        LocalDate currentDay = LocalDate.now();
        System.out.println("Today: "+currentDay);
        System.out.println("10 years after: "+ currentDay.plusYears(10));
        System.out.println("10 months before: "+ currentDay.minusMonths(10));
    }


}
