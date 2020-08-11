package easy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 1360 Number of Days Between Two Dates
 */
public class NumberofDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        return  Math.abs((int) ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
    }
}
