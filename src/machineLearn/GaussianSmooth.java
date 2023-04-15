package machineLearn;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * 该代码实现了对一条简单的曲线进行多次高斯平滑，输出平滑后的曲线点坐标。其中，我们使用了一个一维高斯核对曲线进行平滑，再使用一个二维高斯核对灰度图像进行平滑。经过多次平滑后，可以看到曲线变得十分平滑。
 */
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GaussianSmooth {
    public static void main(String[] args) throws Exception {
        // 构造原始曲线
        ArrayList<Point2D.Double> curve = new ArrayList<>();
        curve.add(new Point2D.Double(0, 0));
        curve.add(new Point2D.Double(2, 1));
        curve.add(new Point2D.Double(4, 3));
        curve.add(new Point2D.Double(5, 2));
        curve.add(new Point2D.Double(7, 5));
        curve.add(new Point2D.Double(9, 2));
        curve.add(new Point2D.Double(11, 3));
        curve.add(new Point2D.Double(13, 1));
        curve.add(new Point2D.Double(15, 0));
        // 进行多次高斯平滑处理
        int n = 3; // 平滑次数
        int radius = 5; // 半径
        double sigma = 0.5; // 标准差
        for (int i = 0; i < n; i++) {
            curve = smoothCurve(curve, radius, sigma);
        }
        // 输出处理后的曲线点
        for (Point2D.Double point : curve) {
            System.out.printf("(%.2f, %.2f) ", point.x, point.y);
        }
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
}