package machineLearn;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

import java.util.Arrays;


/**
 * 上述代码中，train()方法使用了第三方库Apache Commons Math提供的OLS多重线性回归方法来训练模型并返回最佳参数数组。predict()方法则根据训练好的模型参数来预测新的结果。
 *
 * 在main()方法中，我们使用一个由3个自变量和1个因变量组成的样本数据集来训练多重回归模型，并使用训练好的模型对一个新的自变量数据进行预测。
 *
 */
public class MultipleRegression {

    // 训练多重回归模型并返回参数数组
    public static double[] train(double[][] x, double[] y) {

        try {
            OLSMultipleLinearRegression multipleRegression = new OLSMultipleLinearRegression();
            multipleRegression.newSampleData(y, x);
            double[] beta = multipleRegression.estimateRegressionParameters();
            return beta;
        }catch (Exception e){
            System.out.printf("train 出错了");
        }
        return null;

    }

    // 使用训练好的多重回归模型对新数据进行预测
    public static double predict(double[] x, double[] beta) {
        
        double y = beta[0];
        for (int i = 1; i < beta.length; i++) {
            y += beta[i] * x[i - 1];
        }
        return y;
    }

    public static void main(String[] args) {
        
        // 样本数据（假设有3个自变量和1个因变量）
        double[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        double[] y = {1, 2, 3, 4};

        // 训练多重回归模型
        double[] beta = train(x, y);

        // 使用模型进行预测
        double[] x_new = {4, 5, 6};
        double y_new = predict(x_new, beta);
        System.out.println("获取训练参数为：" + Arrays.toString(beta));
        System.out.println("预测结果为：" + y_new);
    }
}