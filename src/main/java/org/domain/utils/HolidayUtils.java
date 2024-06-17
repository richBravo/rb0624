package org.domain.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HolidayUtils {
    /**
     * This method processes the logic for when Labor day is observed.
     * @param date of which is needed to provide the year of the calendar for when Labor day is observed.
     * @return LocalDate object of the day in which Labor day is observed in MM/dd/yy format.
     */
    public static LocalDate getLaborDayDate(LocalDate date){
        LocalDate laborDayIterator = LocalDate.of(date.getYear(), 9, 1);
        while(laborDayIterator.getDayOfWeek() != DayOfWeek.MONDAY){
            laborDayIterator = laborDayIterator.plusDays(1);
        }
        return laborDayIterator;
    }

    /**
     * This method processes the logic for when Independence day is observed.
     * @param date of which is needed to provide the year of the calendar for when Independence day is observed.
     * @return LocalDate object of the day in which Independence day is observed in MM/dd/yy format.
     */
    public static LocalDate getObservedIndependenceDay(LocalDate date){
        LocalDate independenceDayIterator = LocalDate.of(date.getYear(), 7, 4);
        if(independenceDayIterator.getDayOfWeek() == DayOfWeek.SATURDAY){
           independenceDayIterator = independenceDayIterator.minusDays(1);
        } else if (independenceDayIterator.getDayOfWeek() == DayOfWeek.SUNDAY) {
            independenceDayIterator = independenceDayIterator.plusDays(1);
        }
        return independenceDayIterator;
    }
}
