package machineLearn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OscillationCount1 extends JPanel {

    private static final long serialVersionUID = 1L;

    private int[] data;
    private int oscillations = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("曲线震荡计数器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        OscillationCount1 panel = new OscillationCount1();
        frame.add(panel);
        panel.processData();
        frame.setVisible(true);
    }

    public void processData() {
        // 构造样本数据，这里使用随机生成的数据
        data = new int[200];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 200 + 50);
        }

        oscillations = getOscillationCount(data);

        // 通知面板进行重新绘制
        repaint();
    }

    private double[] gaussianSmooth(int[] data, double sigma) {
        double[] weights = new double[data.length];
        double[] smoothed = new double[data.length];
        double sum = 0, wsum = 0;

        for (int i = 0; i < data.length; i++) {
            double wt = Math.exp(-0.5 * i * i / sigma / sigma);
            sum += wt * data[i];
            wsum += wt;
            weights[i] = wt;
        }

        for (int i = 0; i < data.length; i++) {
            smoothed[i] = sum / wsum;
            sum -= weights[i] * data[i];
            wsum -= weights[i];

            if (i + (int) sigma < data.length) {
                sum += weights[(int) sigma + i] * data[(int) sigma + i];
                wsum += weights[(int) sigma + i];
            }
        }

        return smoothed;
    }

    private int getOscillationCount(int[] data) {
        double[] smoothedValues = gaussianSmooth(data, 5);

        double[] diffValues = new double[smoothedValues.length - 1];
        for (int i = 0; i < diffValues.length; i++) {
            diffValues[i] = smoothedValues[i + 1] - smoothedValues[i];
        }
        int oscillations = 0;
        for (int i = 1; i < diffValues.length; i++) {
            if (diffValues[i - 1] >= 0 && diffValues[i] < 0) {
                oscillations++;
            } else if (diffValues[i - 1] <= 0 && diffValues[i] > 0) {
                oscillations++;
            }
        }
        return oscillations;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (data != null) {
            g.drawString("曲线数据： " + Arrays.toString(data), 10, 40);
            g.drawString("曲线震荡次数： " + Integer.toString(oscillations), 10, 60);

            // 绘制原始曲线
            g.setColor(Color.BLUE);
            for (int i = 0; i < data.length - 1; i++) {
                g.drawLine(50 + i, 300 - data[i], 50 + i + 1, 300 - data[i + 1]);
            }

            // 绘制平滑后的曲线
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            double[] smoothedValues = gaussianSmooth(data, 5);
            int[] smoothedIntValues = new int[smoothedValues.length];
            for (int i = 0; i < smoothedValues.length; i++) {
                smoothedIntValues[i] = 300 - (int) smoothedValues[i];
            }
            g2d.drawPolyline(getXCoordinatesForData(smoothedValues.length), smoothedIntValues, smoothedValues.length);

        }
    }

    private int[] getXCoordinatesForData(int length) {
        int[] xCoords = new int[length];
        for(int i=0; i<length; i++) {
            xCoords[i] = 50 + i;
        }
        return xCoords;
    }
}
