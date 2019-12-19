package easy;

/**
 * num1154 Day of the Year
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 * Example 2:
 * <p>
 * Input: date = "2019-02-10"
 * Output: 41
 * Example 3:
 * <p>
 * Input: date = "2003-03-01"
 * Output: 60
 * Example 4:
 * <p>
 * Input: date = "2004-03-01"
 * Output: 61
 */
public class DayOfTheYear {
    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int days = Integer.parseInt(split[2]);
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        day[1] += ((year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)))?1:0;
        int result =0;
        for (int i = 0; i < month-1; i++) {
            result+=day[i];
        }
        return result+days;
    }
}
