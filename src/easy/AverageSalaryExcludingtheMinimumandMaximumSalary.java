package easy;

/**
 * 1491 Average Salary Excluding the Minimum and Maximum Salary
 */
public class AverageSalaryExcludingtheMinimumandMaximumSalary {
    public double average(int[] salary) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for (int i : salary) {
            sum+=i;
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        return (sum-max-min)/(salary.length-2.0);

    }
}
