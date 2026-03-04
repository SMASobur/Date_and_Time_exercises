package se.lexicon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    static void main() {
        // Exercise 1 – Current Date
        currentDate();
        // Exercise 2 – Formatted Current Date
        formattedDate();
        // Exercise 3 – Last Monday and the Entire Week
        lastMondayWeek();
        // Exercise 4 – Parse Date from String
        parseDate("2023-12-25");

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
}
