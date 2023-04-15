package machineLearn;

import java.util.Random;

/**
 * 这里给出使用Java语言实现随机梯度下降算法的一个简单例子，以线性回归为例。
 * 假设我们的训练数据是一个二维数组 x，y 是一个一维数组，表示训练集的特征和标签，且 x 和 y 的长度一致。
 * 我们的目标是通过训练数据训练出一个线性回归模型，使得输出结果与真实值之间的误差最小。
 */
public class LinearRegression {
    private double[] theta;
    private double alpha;

    public LinearRegression(int numFeatures, double alpha) {
        // 初始化模型参数theta为随机值
        Random rand = new Random();
        theta = new double[numFeatures + 1];
        for (int i = 0; i < numFeatures + 1; i++) {
            theta[i] = rand.nextDouble();
        }
        this.alpha = alpha;
    }

    public void train(double[][] x, double[] y, int numIterations) {
        int m = x.length; // 样本数
        int n = x[0].length; // 特征数
        for (int i = 0; i < numIterations; i++) {
            // 随机选择一个样本
            int idx = new Random().nextInt(m);
            double[] xi = new double[n + 1];
            xi[0] = 1.0;
            for (int j = 0; j < n; j++) {
                xi[j + 1] = x[idx][j];
            }

            // 计算梯度
            double[] gradient = new double[n + 1];
            for (int j = 0; j < n + 1; j++) {
                double hx = 0.0;
                for (int k = 0; k < n + 1; k++) {
                    hx += theta[k] * xi[k];
                }
                gradient[j] = (hx - y[idx]) * xi[j];
            }

            // 更新模型参数
            for (int j = 0; j < n + 1; j++) {
                theta[j] = theta[j] - alpha * gradient[j];
            }
        }
    }

    public double[] predict(double[][] x) {
        int m = x.length;
        int n = x[0].length;
        double[] y_pred = new double[m];
        for (int i = 0; i < m; i++) {
            double hx = 0.0;
            for (int j = 0; j < n; j++) {
                hx += theta[j + 1] * x[i][j];
            }
            hx += theta[0];
            y_pred[i] = hx;
        }
        return y_pred;
    }

    /**
     * 这里的 train 方法用于训练模型，输入 x 数组表示训练集数据，y 数组表示训练集标签，numIterations 表示训练的迭代次数。
     * 在每次迭代中，我们随机选择一个训练样本，计算样本的梯度，并根据梯度更新模型参数。
     * predict 方法用于预测测试集的标签值，输入 x 数组表示测试集数据，返回 y_pred 数组表示预测的标签值。
     * 具体的训练和预测过程可以参考下面的代码：
     */

    public static void main(String[] args) {
        // 训练集数据
        double[][] x_train = {{1.0, 2.0}, {2.0, 3.0}, {3.0, 4.0}, {4.0, 5.0}, {5.0, 6.0}};
        double[] y_train = {2.0, 3.0, 4.0, 5.0, 6.0};

        // 创建线性回归模型，并训练模型
        LinearRegression model = new LinearRegression(2, 0.01);
        model.train(x_train, y_train, 10000);

        // 测试集数据
        double[][] x_test = {{6.0, 7.0}, {7.0, 8.0}, {8.0, 9.0}};
        double[] y_test = {7.0, 8.0, 9.0};

        // 预测测试集标签值
        double[] y_pred = model.predict(x_test);

        // 输出预测结果
        for (int i = 0; i < y_test.length; i++) {
            System.out.println("True Value: " + y_test[i] + ", Predict Value: " + y_pred[i]);
        }
    }
}