package uncomplete.tools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tetris extends JPanel implements ActionListener, KeyListener {
    private final int CELL_SIZE = 30;
    private int[][] board = new int[20][10];
    private Timer timer;
    private int currentRow;
    private int currentCol;
    private int[][] currentBlock;
    private int score;

    public Tetris() {
        setPreferredSize(new Dimension(CELL_SIZE * 10, CELL_SIZE * 20));
        setBackground(Color.white);
        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(500, this);
        newBlock();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 10; col++) {
                if (board[row][col] != 0) {
                    g.setColor(Color.gray);
                    g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
        for (int row = 0; row < currentBlock.length; row++) {
            for (int col = 0; col < currentBlock[row].length; col++) {
                if (currentBlock[row][col] != 0) {
                    g.setColor(Color.black);
                    g.fillRect((currentCol + col) * CELL_SIZE, (currentRow + row) * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
        g.setColor(Color.black);
        g.drawString(String.format("Score: %d", score), 10, 30);
    }

    private boolean moveDown() {
        if (!canMove(currentBlock, currentRow + 1, currentCol)) {
            return false;
        }
        currentRow++;
        return true;
    }

    private void newBlock() {
        int blockType = (int) (Math.random() * 7);
        switch (blockType) {
            case 0:
                currentBlock = new int[][] {{1, 1}, {1, 1}};
                break;
            case 1:
                currentBlock = new int[][] {{2, 2, 2, 2}};
                break;
            case 2:
                currentBlock = new int[][] {{0, 0, 3}, {3, 3, 3}};
                break;
            case 3:
                currentBlock = new int[][] {{4, 4, 0}, {0, 4, 4}};
                break;
            case 4:
                currentBlock = new int[][] {{0, 5, 5}, {5, 5, 0}};
                break;
            case 5:
                currentBlock = new int[][] {{6, 0, 0}, {6, 6, 6}};
                break;
            case 6:
                currentBlock = new int[][] {{0, 7, 0}, {7, 7, 7}};
                break;
        }
        currentRow = 0;
        currentCol = board[0].length / 2 - currentBlock[0].length / 2;
        if (!canMove(currentBlock, currentRow, currentCol)) {
            timer.stop();
        }
    }

    private boolean canMove(int[][] block, int row, int col) {
        if (row < 0 || row + block.length > board.length) {
            return false;
        }
        if (col < 0 || col + block[0].length > board[0].length) {
            return false;
        }
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                if (block[i][j] != 0) {
                    if (board[row+i][col+j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void placeBlock() {
        for (int i = 0; i < currentBlock.length; i++) {
            for (int j = 0; j < currentBlock[i].length; j++) {
                if (currentBlock[i][j] != 0) {
                    board[currentRow+i][currentCol+j] = currentBlock[i][j];
                }
            }
        }
    }

    private boolean removeLines() {
        boolean flag = false;
        for (int row = board.length - 1; row >= 0; row--) {
            boolean isFull = true;
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 0) {
                    isFull = false;
                    break;
                }
            }
            if (isFull) {
                for (int r = row; r > 0; r--) {
                    for (int c = 0; c < board[r].length; c++) {
                        board[r][c] = board[r-1][c];
                    }
                }
                row++;
                score++;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moveDown()) {
            repaint();
        } else {
            placeBlock();
            if (removeLines()) {
                repaint();
            }
            newBlock();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (canMove(currentBlock, currentRow, currentCol - 1)) {
                    currentCol--;
                    repaint();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (canMove(currentBlock, currentRow, currentCol + 1)) {
                    currentCol++;
                    repaint();
                }
                break;
            case KeyEvent.VK_DOWN:
                moveDown();
                repaint();
                break;
            case KeyEvent.VK_SPACE:
                for (int row = currentRow; row < board.length; row++) {
                    if (!canMove(currentBlock, row, currentCol)) {
                        break;
                    }
                    currentRow = row;
                    repaint();
                    try { Thread.sleep(10); } catch (Exception ex) {}
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Tetris());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
