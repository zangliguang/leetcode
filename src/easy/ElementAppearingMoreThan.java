package easy;

/**
 * 1287 Element Appearing More Than 25% In Sorted Array
 */
public class ElementAppearingMoreThan {
    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int num = length / 4+1;
        for (int i = 0; i < arr.length-num+1; i++) {
            if(arr[i]==arr[i+num-1])
                return arr[i];

        }
        return arr[0];
    }
}
