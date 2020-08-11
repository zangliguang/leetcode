package easy;

/**
 * 1534 Count Good Triplets
 */
public class CountGoodTriplets {
    public static void main(String[] args) {
        int[] arr=new int[]{3,0,1,1,9,7};
        System.out.println(countGoodTriplets(arr,7,2,3));
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]<=arr[i]+a&&arr[j]>=arr[i]-a){
                    for (int k = j+1; k <arr.length ; k++) {
                        if(arr[k]<=arr[j]+b&&arr[k]>=arr[j]-b&&arr[k]<=arr[i]+c&&arr[k]>=arr[i]-c){
                            result++;
                        }
                    }
                }
            }
        }

        return result;

    }
}
