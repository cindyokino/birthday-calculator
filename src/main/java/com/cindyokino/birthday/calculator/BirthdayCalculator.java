package com.cindyokino.birthday.calculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Cindy
 */
public class BirthdayCalculator {
        public static void main(String[] args){
            
        LocalDate dateToday = LocalDate.now();       
        
        System.out.println("Welcome to the 100% Scientifically Accurate Birthday Calculator!");
        System.out.println();
        
        // ================ Use Scanner to read the user input ================
        Scanner birthdayInput = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What's your birthday? (MM-DD-YYYY)");
        String birthday = birthdayInput.nextLine();  // Read user input 
        System.out.println();
        
        // ================ Transform the user input from a String into a Date ================
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
        LocalDate date = LocalDate.parse(birthday, formatter); // LocalDate = yyyy-M-d (Transforms the string into a Date)
        
        // ================ Discoverthe day of the week user was born ================
        DayOfWeek dayOfWeek = date.getDayOfWeek();  // Extracts a `DayOfWeek` enum object.
        String weekDayBorn = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US); // String = Tuesday
        
        // ================ Calculate this year day of your birthday ================
        LocalDate thisYearBirthday = date.withYear(dateToday.getYear());
        DayOfWeek dayOfWeekThisYear = thisYearBirthday.getDayOfWeek();  // Extracts a `DayOfWeek` enum object.
        String weekDayBornThisYear = dayOfWeekThisYear.getDisplayName(TextStyle.FULL, Locale.US);
        
         // ================ Transform today Date format to "M-d-yyyy" ================
        String formattedDate = dateToday.format(DateTimeFormatter.ofPattern("M-d-yyyy"));
        
        // ================ Calculate how many days until the user's birthday ================
        LocalDate nextBDay = date.withYear(dateToday.getYear());
        //If the birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(dateToday) || nextBDay.isEqual(dateToday)) {
            nextBDay = nextBDay.plusYears(1);
        }
        long daysToNextBDay = ChronoUnit.DAYS.between(dateToday, nextBDay);
        
        // ================ Calculate the user's age ================
        int ageNextBirthday = nextBDay.getYear() - date.getYear();
        
        
        System.out.println("That means you were born on a " + weekDayBorn.toUpperCase() + "!"); // String = TUESDAY
        System.out.println("This year it falls on a " + weekDayBornThisYear.toUpperCase() + "...");
        System.out.println("And since today is " + formattedDate + ",");
        System.out.println("there's only " + daysToNextBDay + " more days until the next one when you turn " + ageNextBirthday + "!");

    }
}
