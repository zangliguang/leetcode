package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. Build an Array With Stack Operations
 */
public class BuildanArrayWithStackOperations {
    public static void main(String[] args) {
        int[] arr=new int[]{1,3};
        System.out.println(buildArray(arr,3));
    }
    public static List<String> buildArray(int[] target, int n) {
        int j=0;
        List<String> a = new ArrayList<String>();
        for(int i=1;i<=n;i++) {
            if(j==target.length) break;
            if(i!=target[j]) {

                a.add("Push");
                a.add("Pop");
                continue;
            }

            j++;
            a.add("Push");
        }
        return a;
//        List<String> result = new ArrayList<>();
//        int start = 1;
//        for (int j = 0; j < target.length; j++) {
//
//            int num =0;
//            for (int i = start; i <= target[j]; i++) {
//                if (i == target[j]) {
//                    for (int k = 0; k < num; k++) {
//                        result.add("Pop");
//                    }
//                    start=i+1;
//                }else{
//                    num++;
//                }
//                result.add("Push");
//
//
//            }
//        }
//
//
//        return result;
    }
}
