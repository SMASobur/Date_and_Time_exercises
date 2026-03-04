package se.lexicon;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
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
        // Exercise 7 – Period Between Dates
        periodBetweenDates(1993,12,7);
        System.out.println();
        // Exercise 8 – Add Period to Current Date
        periodToCurrentDate();
        System.out.println();
        // Exercise 9 – Current Time
        crrentTime();
        System.out.println();
        // Exercise 10 – Nanoseconds of LocalTime
        nanosecondsOfLocalTime();
        System.out.println();
        // Exercise 11 – Parse Time from String
        parseTimeString("10:32:53");
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
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            System.out.println("Parsed Date: " + parsedDate);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Invalid date format provided!");
        }

    }

    //The date time API provides enums for time units such as day and month. Create a LocalDate of your birthday and extract the day of week for that date.
    //Example: 1945-05-08 -> TUESDAY

    public static void dayOfTheWeek(int yyyy, int mm, int dd){
        LocalDate birthday = LocalDate.of(yyyy, mm, dd);
        DayOfWeek day = birthday.getDayOfWeek();
        System.out.println(birthday +" " + day);
    }

    //Create a LocalDate of current date plus 10 years and minus 10 months. From that date extract the month and print it out.
    public static void futurePastDate(){
        LocalDate currentDay = LocalDate.now();
        System.out.println("Today: "+currentDay);
        System.out.println("10 years after: "+ currentDay.plusYears(10));
        System.out.println("10 months before: "+ currentDay.minusMonths(10));
    }

    //Using the LocalDate from exercise 6 and your birthdate, create a Period between your birthdate and the date from exercise 6. Print out the elapsed years, months and days.
    public static void periodBetweenDates(int yyyy, int mm, int dd){
        LocalDate birthday = LocalDate.of(yyyy, mm, dd);
        LocalDate current = LocalDate.now();
        Period diff = Period.between(birthday, current);

        System.out.println("Elapsed years: "+
                diff.getYears()+ " years, " +
                diff.getMonths() + " months, and " +
                diff.getDays() + " days.");
    }

    //Create a period of 4 years, 7 months and 29 days. Then create a LocalDate of current date and add the period you created to the current date.
    public static void periodToCurrentDate(){
        Period customPeriod =Period.of(4,7,29);
        LocalDate current = LocalDate.now();
        System.out.println("Future Date: "+current.plus(customPeriod));

    }

    //Create a LocalTime object of the current time.
    public static void crrentTime(){
        LocalTime time =LocalTime.now();
        System.out.println("Time: "+time);
    }

    //Extract the nanoseconds of a LocalTime object of current time. Print out the nanoseconds.
    public static void nanosecondsOfLocalTime(){
        LocalTime time =LocalTime.now();
        int nanoseconds = time.getNano();
        System.out.println("Time in Nanoseconds: "+nanoseconds);
    }

    //Create a LocalTime object from a String using the .parse() method.
    public static void parseTimeString(String time){
        try {
            LocalTime parsedTime =LocalTime.parse(time);
            System.out.println("Parsed Time: "+parsedTime);
        } catch (java.time.format.DateTimeParseException e){
            System.out.println("Invalid time format provided!");
        }

    }



}
