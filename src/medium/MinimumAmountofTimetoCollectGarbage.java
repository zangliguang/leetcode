package medium;

/**
 * 2391 Minimum Amount of Time to Collect Garbage
 */
public class MinimumAmountofTimetoCollectGarbage {

    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G","P","GP","GG"},new int[]{2,4,3}));
    }
    public static int garbageCollection(String[] garbage, int[] travel) {


        int end1 = 0;
        int end2 = 0;
        int end3 = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        for (int i = 0; i < garbage.length; i++) {
            String current = garbage[i];
            int length = current.length();
            if (current.contains("M")) {

                end1 = i;
                num1 += length - current.replace("M", "").length();
            }
            if (current.contains("P")) {

                end2 = i;
                num2 += length - current.replace("P", "").length();
            }
            if (current.contains("G")) {

                end3 = i;
                num3 += length - current.replace("G", "").length();
            }



        }
        int travel1 = 0;
        int travel2 = 0;
        int travel3 = 0;
        for (int i = 0; i < end1; i++) {
            travel1+=travel[i];
        }
        for (int i = 0; i < end2; i++) {
            travel2+=travel[i];
        }
        for (int i = 0; i < end3; i++) {
            travel3+=travel[i];
        }
        return travel1+travel2+travel3+ num1 + num2 + num3;


    }
}
