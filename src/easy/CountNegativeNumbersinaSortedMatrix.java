package easy;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 */
public class CountNegativeNumbersinaSortedMatrix {
    public int countNegatives(int[][] grid) {
        int result =0;
        int minline=0,minCulumn=0;
        for (int i = grid.length-1,j=grid[0].length-1; i >=0&&j>=0; i--,j--) {
            if(grid[i][j]<0){
                result++;
                for (int i1 = i-1; i1 >= minline; i1--) {
                    if(grid[i1][j]<0){
                        result++;
                    }else{
                        minline=i1;
                        break;
                    }

                }
                for (int j1 = j-1; j1 >= minCulumn; j1--) {
                    if(grid[i][j1]<0){
                        result++;
                    }else{
                        minCulumn=j1;
                        break;
                    }
                }
            }else{
                break;
            }

        }

        return result;
    }
}
