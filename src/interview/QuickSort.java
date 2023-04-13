package interview;

import java.util.Arrays;

public class QuickSort {

    //测试
    public static void main(String[] args) {
        int[] array = {6,3,7,1,9,4,8,5,2,10};
        int low = 0,high = array.length - 1;
        quickRow(array,low,high);
        System.out.println(Arrays.toString(array));
    }

    //快排实现方法
    public static void quickRow(int[] array, int low, int high){
        System.out.println("第"+low+"到"+high+"判断");
        int i,j,pivot;
        //结束条件
        if (low >= high) {
            System.out.println("取消判断");
            return;
        }
        i = low;
        j = high;
        //选择的节点，这里选择的数组的第一数作为节点
        pivot = array[low];
        while (i < j){
            //从右往左找比节点小的数，循环结束要么找到了，要么i=j
            while (array[j] >= pivot && i < j){
                j--;
            }
            //从左往右找比节点大的数，循环结束要么找到了，要么i=j
            while (array[i] <= pivot && i < j){
                i++;
            }
            //如果i!=j说明都找到了，就交换这两个数
            if (i < j){
                System.out.println("交换"+array[i]+"和"+array[j]);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("循环结束，设第"+low+"项="+array[i]+" 第"+i+"项="+pivot);

        //i==j一轮循环结束，交换节点的数和相遇点的数
        array[low] = array[i];
        array[i] = pivot;
        System.out.println(Arrays.toString(array));
        //数组“分两半”,再重复上面的操作
        quickRow(array,low,i - 1);
        quickRow(array,i + 1,high);
    }


}
