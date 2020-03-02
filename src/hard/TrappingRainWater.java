package hard;

/**
 * 42. Trapping Rain Water
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap2(int[] height) {
        int result =0;
        int left = height[0];
        int right = height[height.length-1];
        for (int i = 1; i < height.length; i++) {
            if(height[i]>left){
                left=height[i];
            }
        }

        return result;
    }
    public static int trap(int[] height) {
        int result =0;
        for (int i = 1; i < height.length-1; i++) {
            int high = Math.min(max(0,i-1, height), max(i+1,height.length-1, height)) - height[i];
            result+= high>0?high:0;
        }
        return result;
    }
    private static int  max(int start,int end,int[] height){
        int result =0;
        for (int i = start; i <=end ; i++) {
            if(result<height[i]){
                result =height[i];
            }
        }
        return result;
    }
}
