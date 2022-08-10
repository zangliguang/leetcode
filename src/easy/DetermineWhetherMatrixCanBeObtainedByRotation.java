package easy;

/**
 * 1886 Determine Whether Matrix Can Be Obtained By Rotation
 */
public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        if (equals(mat, target)) {
            return true;
        }
        boolean result = roatatEqual(mat, target);
        if (result) {
            return true;
        }

         result = roatat2Equal(mat, target);
        if (result) {
            return true;
        }
        return roatat3Equal(mat, target);
    }

    private boolean roatatEqual(int[][] mat, int[][] target) {
        int l= mat.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if(mat[l-j-1][i]!= target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean roatat2Equal(int[][] mat, int[][] target) {
        int l= mat.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if(mat[l-i-1][l-j-1]!= target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean roatat3Equal(int[][] mat, int[][] target) {
        int l= mat.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if(mat[j][l-i-1]!= target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean equals(int[][] mat, int[][] target) {
        int l=mat.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if(mat[i][j]!=target[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}
