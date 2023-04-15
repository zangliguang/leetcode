package machineLearn;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * 该代码实现了对一张名为lena.png的图像进行高斯滤波后输出为lena_blur.png。在示例代码中，我们使用了BufferedImage类来加载和处理图像，并且较为详细地实现了高斯滤波器的权值计算和卷积操作。
 */
public class GaussianBlur {
    public static void main(String[] args) throws Exception {
        // 加载原始图像
        BufferedImage image = ImageIO.read(new File("resource/lena.JPG"));
        int width = image.getWidth();
        int height = image.getHeight();
        // 定义高斯滤波器参数，半径为5，标准差为2.0
        int radius = 5;
        double sigma = 2.0;
        // 计算高斯滤波器的权值矩阵
        double[][] kernel = getGaussianKernel(radius, sigma);
        // 对原始图像进行高斯滤波
        BufferedImage result = applyKernel(image, kernel);
        // 输出处理后的图像
        ImageIO.write(result, "JPG", new File("resource/lena_blur.JPG"));
    }

    /**
     * 获取给定半径和标准差的高斯滤波器权值矩阵
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
     * 对给定图像应用卷积核
     */
    public static BufferedImage applyKernel(BufferedImage image, double[][] kernel) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, image.getType());
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double sumR = 0.0, sumG = 0.0, sumB = 0.0, sumA = 0.0, sumW = 0.0;
                for (int i = 0; i < kernel.length; i++) {
                    for (int j = 0; j < kernel.length; j++) {
                        int x2 = x + i - kernel.length / 2;
                        int y2 = y + j - kernel.length / 2;
                        if (x2 >= 0 && x2 < width && y2 >= 0 && y2 < height) {
                            int rgb = image.getRGB(x2, y2);
                            double w = kernel[i][j];
                            sumR += w * ((rgb >> 16) & 0xFF);
                            sumG += w * ((rgb >> 8) & 0xFF);
                            sumB += w * (rgb & 0xFF);
                            sumA += w * ((rgb >> 24) & 0xFF);
                            sumW += w;
                        }
                    }
                }
                // 写入处理后的像素值
                if (sumW > 0.0) {
                    int r = (int) (sumR / sumW);
                    int g = (int) (sumG / sumW);
                    int b = (int) (sumB / sumW);
                    int a = (int) (sumA / sumW);
                    int rgb = (a << 24) | (r << 16) | (g << 8) | b;
                    result.setRGB(x, y, rgb);
                }
            }
        }
        return result;
    }
}
