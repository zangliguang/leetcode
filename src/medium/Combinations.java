package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * num77
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(i);
            setResult(result, integers,n,i+1,k-1);
        }

        return result;
    }

    private static void setResult(List<List<Integer>> result, ArrayList<Integer> item, int n, int index, int k) {
        ArrayList<Integer> integers =new ArrayList<>(item);
        if(0==k){
            result.add(integers);

        }else{
            for (int i = index; i <= n; i++) {
                integers.add(i);
                setResult(result, integers,n,i+1,k-1);
                integers.remove(integers.size()-1);
            }
        }



    }
}
