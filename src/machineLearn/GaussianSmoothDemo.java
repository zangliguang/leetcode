package machineLearn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 这个代码会把原始曲线进行高斯平滑，并在窗口中呈现出原始曲线和平滑后的曲线。
 *
 * 当运行一个程序后，将坐标的原点移动到了窗口左下角，所以在绘制曲线时，需要将 y 坐标减去曲线数据中的 y 值，以确保曲线朝上。
 *
 * 在这个演示程序中，我使用 JPanel 类来创建了一个 GUI 窗口，用于绘制原始曲线和平滑后的曲线。为了在窗口中绘制曲线，我使用 drawLine 方法将相邻的曲线点连接成一条线段。你可以尝试通过调整不同的半径和标准差参数来观察高斯平滑的效果。
 */
public class GaussianSmoothDemo extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private ArrayList<Point2D.Double> curve; // 原始曲线
    private ArrayList<Point2D.Double> smoothedCurve; // 平滑后的曲线

    public GaussianSmoothDemo() {
        // 构造原始曲线
        curve = new ArrayList<>();
        curve.add(new Point2D.Double(40, 50));
        curve.add(new Point2D.Double(100, 10));
        curve.add(new Point2D.Double(200, 90));
        curve.add(new Point2D.Double(250, 60));
        curve.add(new Point2D.Double(320, 150));
        curve.add(new Point2D.Double(400, 70));
        curve.add(new Point2D.Double(480, 90));
        curve.add(new Point2D.Double(540, 10));
        curve.add(new Point2D.Double(600, 50));
        curve.add(new Point2D.Double(700, 70));

        int n = 300; // 平滑次数
        int radius = 50; // 半径
        double sigma = 10.05; // 标准差
        smoothedCurve = new ArrayList<>(curve);
        // 多次高斯平滑处理
        for (int i = 0; i < n; i++) {
            smoothedCurve = smoothCurve(smoothedCurve, radius, sigma);
        }

        JFrame frame = new JFrame("Gaussian Smooth Demo");
        frame.add(this);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 绘制原始曲线和平滑后的曲线
        drawCurve(g, curve, Color.RED);
        drawCurve(g, smoothedCurve, Color.BLUE);
    }

    /**
     * 对曲线进行高斯平滑
     */
    public static ArrayList<Point2D.Double> smoothCurve(ArrayList<Point2D.Double> curve, int radius, double sigma) {
        int n = curve.size();
        if (n < 2 * radius) {
            return curve;
        }
        // 将曲线转化为灰度图像
        double[][] gray = new double[1][n];
        for (int i = 0; i < n; i++) {
            gray[0][i] = curve.get(i).y;
        }
        // 计算卷积核
        double[][] kernel = getGaussianKernel(radius, sigma);
        // 对灰度图像进行高斯平滑
        double[][] result = applyKernel(gray, kernel);
        // 将平滑后的灰度值转化为曲线点
        ArrayList<Point2D.Double> smoothedCurve = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            smoothedCurve.add(new Point2D.Double(curve.get(i).x, result[0][i]));
        }
        return smoothedCurve;
    }

    /**
     * 获取给定半径和标准差的二维高斯核
     */
    public static double[][] getGaussianKernel(int radius, double sigma) {
        int size = 2 * radius + 1;
        double[][] kernel = new double[size][size];
        double sum = 0.0;
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                double x = i * i + j * j;
                double g = Math.exp(-x / (2 * sigma * sigma));
                kernel[i + radius][j + radius] = g;
                sum += g;
            }
        }
        // 归一化
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                kernel[i][j] /= sum;
            }
        }
        return kernel;
    }

    /**
     * 对给定数组应用二维卷积核
     */
    public static double[][] applyKernel(double[][] data, double[][] kernel) {
        int n = data.length;
        int m = data[0].length;
        int k = kernel.length;
        double[][] result = new double[n][m];
        int radius = k / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double sum = 0.0;
                for (int x = -radius; x <= radius; x++) {
                    for (int y = -radius; y <= radius; y++) {
                        int row = i + x;
                        int col = j + y;
                        if (row < 0 || row >= n || col < 0 || col >= m) {
                            continue;
                        }
                        double w = kernel[x + radius][y + radius];
                        sum += data[row][col] * w;
                    }
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    /**
     * 绘制曲线
     */
    private void drawCurve(Graphics g, ArrayList<Point2D.Double> curve, Color color) {
        g.setColor(color);
        for (int i = 0; i < curve.size() - 1; i++) {
            Point p1 = new Point((int) curve.get(i).getX(), (int) curve.get(i).getY());
            Point p2 = new Point((int) curve.get(i + 1).getX(), (int) curve.get(i + 1).getY());
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public static void main(String[] args) {
        new GaussianSmoothDemo();
    }
}