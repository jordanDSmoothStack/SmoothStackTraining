package com.ss.basics.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class DateTime {

    public static void main(String[] args) {
      if (args.length == 0 || args.length != 3){
            System.out.println("");
            System.out.println("Please provide three arguments");
            System.out.println("");
      }else{
            String givenYear = args[0];
            String givenMonth = args[1];
            String givenDate = args[2];

            reportLengthOfMonth(givenYear);
            System.out.println("=================================");
            mondayList(givenMonth);
            System.out.println("=================================");
            OccursOnFriday13th(givenDate);
            System.out.println();
      }  
    }

    public static void OccursOnFriday13th(String date){
        LocalDate theDate = LocalDate.parse(date);
        try{
            if (theDate.getDayOfWeek() == DayOfWeek.FRIDAY && theDate.getDayOfMonth() == 13){
                System.out.println();
                System.out.println("That date does occur on Friday the 13th");
            }
            else{
                System.out.println();
                System.out.println("That date does not occur on Friday the 13th");
            }
        }
        catch (Exception e){
            System.out.println();
            System.out.println("Please provide a date format like 2020-11-13");
        }

    }

    public static void reportLengthOfMonth(String year){
        int monthCounter = 1;
        while (monthCounter < 13){
            try{
                YearMonth givenYearAndMonth = YearMonth.of(Integer.parseInt(year), monthCounter);
                System.out.println();
                System.out.println(givenYearAndMonth.getMonth() + " has this many days " + givenYearAndMonth.lengthOfMonth());
                monthCounter++;
            }
            catch (NumberFormatException e){
                System.out.println();
                System.out.println("Please provide a valid year for the first example...");
                break;
            }
            finally{
                System.out.println();
            }
        }
    }

    public static void mondayList(String month){
        LocalDateTime currentTime = LocalDateTime.now();
        int currentYear = currentTime.getYear();
        List<LocalDate> datesArray = new ArrayList<LocalDate>(10);
        try{
            YearMonth givenMonth = YearMonth.of(currentYear, Integer.parseInt(month));
            LocalDate StartDay = givenMonth.atDay(1);
            LocalDate EndDay = givenMonth.atEndOfMonth();
            if (StartDay.getDayOfWeek() == DayOfWeek.MONDAY){
                datesArray.add(StartDay);
            }
            while (StartDay.isBefore(EndDay)){
                StartDay = StartDay.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                if (StartDay.isAfter(EndDay)){
                    break;
                }
                datesArray.add(StartDay);
            }
            System.out.println();
            System.out.println("The following days are Mondays: " + datesArray);
            System.out.println();

        }
        catch (Exception e){
            System.out.println();
            System.out.println("Please provide a valid month for the second example...");
        }
    }
}
