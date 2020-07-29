package easy;

/**
 * 733. Flood Fill
 *
 * [1,1,1],
 * [1,1,0],
 * [1,0,1]
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            dfs(image, sr, sc, image[sr][sc], newColor);
        return image;

    }

    private void dfs(int[][] image, int i, int j, int originColor, int newColor) {

        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != originColor) return;
        image[i][j] = newColor;
        dfs(image, i, j - 1, originColor, newColor);
        dfs(image, i, j + 1, originColor, newColor);
        dfs(image, i - 1, j, originColor, newColor);
        dfs(image, i + 1, j, originColor, newColor);
    }
}
