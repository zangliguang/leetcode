package hard;

import java.util.Arrays;

public class MinimumSpaceWastedFromPackaging {
    public static void main(String[] args) {


        System.out.println(1599960000L%(1000000007L));
    }
    public static int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int result=Integer.MAX_VALUE;
        for (int i = 0; i < boxes.length; i++) {
            int[] current=boxes[i];
            result=Math.min(getValue(current,packages),result);
        }

        return result==Integer.MAX_VALUE?-1:result;
    }

    private static int getValue(int[] boxes,int[]packages) {
        Arrays.sort(boxes);
        if(boxes[boxes.length-1]<packages[packages.length-1]){
            return Integer.MAX_VALUE;
        }
        int result=0;
        int currentIndex=0;
        for (int i = 0; i < packages.length; i++) {
            for (int j = currentIndex; j < boxes.length; j++) {
                if(boxes[j]>=packages[i]){
                    result+=boxes[j]-packages[i];
                    currentIndex=j;
                    break;
                }
            }
            System.out.println(result);
        }
        return result;

    }
}
