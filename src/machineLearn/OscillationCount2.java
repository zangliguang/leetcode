package machineLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OscillationCount2 extends JPanel {

    private static final int NUM_POINTS = 20;
    private static final double X_INTERVAL = 0.05;
    private static final double Y_RANGE = 30.0;

    private DataPoint[] data;
    private int oscillationCount;

    private long seed;
    private JButton btnGenerate;

    public OscillationCount2() {
        seed = System.currentTimeMillis();
        initData();

        // 添加按钮
        btnGenerate = new JButton("重新生成数据");
        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seed = System.currentTimeMillis(); // 更新随机种子
                initData();
                processData();
                repaint();
            }
        });

        setLayout(new BorderLayout());
        add(btnGenerate, BorderLayout.NORTH);
    }

    private void initData() {
        data = new DataPoint[NUM_POINTS];
        Random rnd = new Random(seed);
        for (int i = 0; i < NUM_POINTS; i++) {
            double x = i * X_INTERVAL;
            double y = rnd.nextDouble() * Y_RANGE;
            data[i] = new DataPoint(x, y);
        }
        oscillationCount = -1; // 表示需要重新计算震荡次数
    }

    private void processData() {
        smoothData(data, 5);
        oscillationCount = countOscillations(data);
    }

    private void smoothData(DataPoint[] data, int windowSize) {
        double[] w = new double[windowSize];
        for (int i = 0; i < windowSize; i++) {
            w[i] = Math.exp(-0.5 * (i * i) / (windowSize * windowSize));
        }

        for (int i = 0; i < NUM_POINTS; i++) {
            double x = data[i].getX();
            double sum = 0.0;
            double weightSum = 0.0;
            for (int j = -windowSize / 2; j <= windowSize / 2; j++) {
                int k = i + j;
                if (k >= 0 && k < NUM_POINTS) {
                    sum += w[Math.abs(j)] * data[k].getY();
                    weightSum += w[Math.abs(j)];
                }
            }
            data[i] = new DataPoint(x, sum / weightSum);
        }
    }

    private int countOscillations(DataPoint[] data) {
        if (data.length < 3) {
            return 0;
        }

        int count = 0;
        boolean increasing = data[1].getY() > data[0].getY();
        for (int i = 2; i < NUM_POINTS; i++) {
            if (data[i].getY() > data[i - 1].getY() && !increasing) {
                increasing = true;
                count++;
            } else if (data[i].getY() < data[i - 1].getY() && increasing) {
                increasing = false;
                count++;
            }
        }

        return count;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
        int margin = 40;
        int x0 = margin;
        int y0 = h - margin;
        int x1 = w - margin;
        int y1 = margin;

        g.setColor(Color.BLACK);
        g.drawLine(x0, y0, x1, y0);
        g.drawLine(x0, y0, x0, y1);

        if (data == null) {
            return;
        }

        double dx = (x1 - x0) / (NUM_POINTS - 1.0);
        double dy = (y0 - y1) / Y_RANGE;

        g.setColor(Color.BLUE);
        for (int i = 0; i < NUM_POINTS - 1; i++) {
            int x = (int) Math.round(x0 + i * dx);
            int y = (int) Math.round(y0 - data[i].getY() * dy);
            int xNext = (int) Math.round(x0 + (i + 1) * dx);
            int yNext = (int) Math.round(y0 - data[i + 1].getY() * dy);
            g.drawLine(x, y, xNext, yNext);
        }

        g.setColor(Color.RED);
        g.drawString("震荡次数：" + oscillationCount, x0, y1 + margin / 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("曲线震荡计数器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        OscillationCount2 panel = new OscillationCount2();
        frame.add(panel);

        panel.processData();

        frame.setVisible(true);
    }
    public class DataPoint {
        private double x;
        private double y;

        public DataPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}
