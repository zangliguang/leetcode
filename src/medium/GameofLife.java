package medium;

/**
 * 289. Game of Life
 */
public class GameofLife {

    public static void main(String[] args) {
        int b=2;
        b>>=1;
        System.out.println(b);
        System.out.println(2>>1);
    }
    public void gameOfLife(int[][] board) {

        int[][] temp=board.clone();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                board[i][j]=nextStatus(getNeighbour(temp,i,j),board[i][j]);
            }
        }
    }

    private int nextStatus(int neighbors, int status) {

        if(status==1){
            if(neighbors==2 || neighbors==3)
                status=1;
        }else{
            if(neighbors==3)
                status=1;
        }
        return status;

    }
    private int getNeighbour(int[][] board, int row, int col){
        int cnt=0;
        for(int i=row-1;i<=row+1;++i){
            for(int j=col-1;j<=col+1;++j){
                if(i>=0 && i<board.length && j>=0 && j<board[0].length){
                    cnt += board[i][j]&1;
                }
            }
        }
        cnt-=board[row][col]&1;
        return cnt;
    }
}
