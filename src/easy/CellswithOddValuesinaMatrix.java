package easy;

import java.util.HashSet;

/**
 * 1252. Cells with Odd Values in a Matrix
 * Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 *
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 */
public class CellswithOddValuesinaMatrix {

    public static void main(String[] args) {
        int[][] indices ={{1,1},{0,0}};
        System.out.println(oddCells(2,2,indices));
    }
    public static int oddCells(int n, int m, int[][] indices) {
        HashSet row =new HashSet<Integer>();
        HashSet culmn =new HashSet<Integer>();
        for (int i = 0; i < indices.length; i++) {
            if(row.contains(indices[i][0])){
                row.remove(indices[i][0]);
            }else{
                row.add(indices[i][0]);
            }
            if(culmn.contains(indices[i][1])){
                culmn.remove(indices[i][1]);
            }else{
                culmn.add(indices[i][1]);
            }
        }
        if(row.size()==n||m==culmn.size()){
            return m*n - row.size()*culmn.size();
        }
        return row.size()*m+culmn.size()*n - 2*row.size()*culmn.size();


    }

    public static int oddCells2(int n, int m, int[][] indices) {
        boolean r[] = new boolean[n];
        boolean c[] = new boolean[m];
        int row_odd = 0, col_odd = 0;

        for (int i = 0; i < indices.length; i++){
            r[indices[i][0]] = !r[indices[i][0]];
            c[indices[i][1]] = !c[indices[i][1]];
            row_odd += r[indices[i][0]] ? 1 : -1;
            col_odd += c[indices[i][1]] ? 1 : -1;
        }

        return (row_odd*m) + (col_odd*n) - (2*row_odd*col_odd);

    }

    public int oddCells3(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int[] indice : indices) {
            rows[indice[0]]++;
            cols[indice[1]]++;
        }
        int row_odd = 0;
        int row_even = 0;
        int col_odd = 0;
        int col_even = 0;
        for (int row : rows) {
            if (row % 2 == 0) {
                row_even++;
            } else {
                row_odd++;
            }
        }
        for (int col : cols) {
            if (col % 2 == 0) {
                col_even++;
            } else {
                col_odd++;
            }
        }
        return row_odd * m - col_odd * row_odd + row_even * m - col_even * row_even;
    }
}
