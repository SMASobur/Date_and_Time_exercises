package se.lexicon;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

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
        // Exercise 12 – Formatted Current Time
        formattedTime();
        System.out.println();
        // Exercise 13 – Specific LocalDateTime
        specificDateTime();
        System.out.println();
        // Exercise 14 – Formatted LocalDateTime
        formattedDateTime();
        System.out.println();
        // Exercise 15 – Combine Date and Time
        combineDateTime();
        System.out.println();
        // Exercise 16 – Extract Components from LocalDateTime
        extractComponents();
        System.out.println();
        // Extra Challenge – Calendar for 2018
        calender2018();
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

    //Using DateTimeFormatter format LocalTime from current time and print it out as following pattern: 10:32:53.
    public static void formattedTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.now();
        System.out.println("Formatted Time: "+time.format(formatter));
    }

    //Create a LocalDateTime with the date and time components as: date: 2018-04-05, time: 10.00.
    public static void specificDateTime(){
        LocalDateTime dateTime =LocalDateTime.of(2018,4,5,10,0);
        System.out.println("Date and Time: "+dateTime);
    }

    //Using DateTimeFormatter format the LocalDateTime object from exercise 13 to a String that should look like this: torsdag 5 april 10:00.
    public static void formattedDateTime(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("eeee dd MMMM HH:mm", new Locale("bn", "BD"));
        LocalDateTime dateTime =LocalDateTime.of(2018,4,5,10,0);
        String formatted = dateTime.format(formatter);
        System.out.println("Formatted Date and Time: "+ formatted);
    }

    //Create a LocalDateTime object by combining LocalDate object and LocalTime object.
    public static void combineDateTime(){
        LocalDate date =LocalDate.now();
        LocalTime time =LocalTime.now();
        LocalDateTime combined = date.atTime(time);
        System.out.println(combined);
    }

    //Create a LocalDateTime object. Then get the LocalDate and LocalTime components into separate objects of respective types from the LocalDateTime object.
    public static void extractComponents(){
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = dateTime.toLocalDate();
        LocalTime time = dateTime.toLocalTime();
        System.out.println("Together: " + dateTime);
        System.out.println("Date: " + date);
        System.out.println("Time: "+time);
    }

    //Create your own calendar for the year 2018. The program should print out all days of the year, organized in a monthly calendar style.
    public static void calender2018(){
        int year =2018;
        for (int month = 1; month <= 12; month++) {
            YearMonth yearMonth = YearMonth.of(year, month);

            // Print Month and Year Header
            String monthName = yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            System.out.println("\n      " + monthName + " " + year);
            System.out.println("Su Mo Tu We Th Fr Sa");

            // Get the day of the week for the 1st of the month
            LocalDate firstOfMonth = yearMonth.atDay(1);
            int dayOfWeekValue = firstOfMonth.getDayOfWeek().getValue();

            // Adjust so Sunday is the first column (0 spaces if Sunday)
            int spaces = (dayOfWeekValue == 7) ? 0 : dayOfWeekValue;

            // Print initial padding spaces
            for (int i = 0; i < spaces; i++) {
                System.out.print("   ");
            }

            // Print days of the month
            for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
                System.out.printf("%2d ", day);

                // Break line every 7th column
                if ((day + spaces) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }




}
