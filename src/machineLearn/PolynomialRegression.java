package machineLearn;

import java.util.Arrays;
import java.util.Vector;
import Jama.LUDecomposition;
/**
 * 该代码示例中，我们使用Java实现了多项式回归，并对一组示例数据进行了拟合和预测。
 * 具体来说，我们定义了一个PolynomialRegression类，该类包含一个构造函数和一个预测函数。
 * 其中，构造函数接受一组x值和y值，并指定多项式回归的级数。
 * 在构造函数中，我们首先将x值转化为矩阵形式，并计算出β系数。
 * 预测函数则接收一个x值，并返回预测的y值。
 *
 * 为了实现多项式回归的计算过程，我们还定义了一个Matrix类，用于表示矩阵及相关运算，例如矩阵相乘、转置以及求解线性方程组等。
 * 值得注意的是，在多项式回归中，我们需要防范过拟合的问题。
 * 因此，我们需要在实际应用中对多项式回归的级数进行适当的调整，以取得更好的预测效果。
 */
import Jama.Matrix;
import java.util.ArrayList;
import java.util.List;

/**
 * 多项式回归算法
 */
import java.util.ArrayList;
import java.util.List;


/**
 * PolynomialRegression(int degree)：构造函数，传入多项式的次数。
 * addData(Data data)：添加一个数据点。
 * train()：训练模型，求出多项式的系数。
 * predict(double x)：预测一个输入变量得到的输出。
 * calculateCoefficients()：获取多项式的系数。
 *
 *

 degree 表示多项式的次数，也就是系数的个数。
 beta 表示模型的系数。在这里，我们使用矩阵计算来求解系数。
 构造函数需要输入 x 值、y 值和多项式的次数（系数的个数）。
 具体流程如下：

 构建矩阵 X。X 的大小为 n * (degree+1)，每一行都是 x[i] 的 degree 次幂的组合。
 构建矩阵 Y，大小为 n*1，每一行都是 y[i]。
 求解系数 beta：先求过矩阵 X 的转置和矩阵 X 的乘积的逆矩阵，再和矩阵 X 的转置和矩阵 Y 的乘积相乘。
 预测新的数据：按照公式，计算出新数据点的 y 值。
 *
 */

public class PolynomialRegression {
    private int degree;
    private List<Data> dataList;
    private double[] coefficients;

    public PolynomialRegression(int degree) {
        this.degree = degree;
        this.dataList = new ArrayList<>();
    }

    public PolynomialRegression(int degree, double[][] data, double[] target) {
        this.degree = degree;
        this.dataList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            this.dataList.add(new Data(data[i], target[i]));
        }
        this.train();
    }

    public void addData(Data data) {
        this.dataList.add(data);
    }

    public void train() {
        int dataSize = dataList.size();
        double[][] inputMatrix = new double[dataSize][degree + 1];
        double[] targetVector = new double[dataSize];
        for (int i = 0; i < dataSize; i++) {
            inputMatrix[i][0] = 1;
            for (int j = 1; j <= degree; j++) {
                inputMatrix[i][j] = Math.pow(dataList.get(i).getX(), j);
            }
            targetVector[i] = dataList.get(i).getY();
        }
        double[][] transposeInput = transposeMatrix(inputMatrix);
        double[][] productMatrix = matrixProduct(transposeInput, inputMatrix);
        double[][] inversedMatrix = matrixInverse(productMatrix);
        double[] productVect = matrixVectorProduct(transposeInput, targetVector);
        coefficients = matrixVectorProduct(inversedMatrix, productVect);
    }

    public double predict(double x) throws Exception {
        if (coefficients == null) {
            throw new Exception("Model not trained");
        }
        double result = coefficients[0];
        for (int i = 1; i <= degree; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public double[] calculateCoefficients() {
        return coefficients;
    }

    private double[][] transposeMatrix(double[][] array) {
        int length = array.length;
        int width = array[0].length;
        double[][] result = new double[width][length];
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < width; ++j) {
                result[j][i] = array[i][j];
            }
        }
        return result;
    }

    // 矩阵相乘
    private double[][] matrixProduct(double[][] array1, double[][] array2) {
        int length1 = array1.length;
        int width1 = array1[0].length;
        int length2 = array2.length;
        int width2 = array2[0].length;
        double[][] result = new double[length1][width2];
        if (width1 != length2) {
            System.err.println("the column number does not match the row number");
            return null;
        }
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < width2; j++) {
                for (int k = 0; k < width1; k++) {
                    result[i][j] += array1[i][k] * array2[k][j];
                }
            }
        }
        return result;
    }

    // 矩阵求逆
    private double[][] matrixInverse(double[][] array) {
        int len = array.length;
        double[][] tmp = new double[len][2 * len];
        double[][] inverse = new double[len][len];
        for (int i = 0; i < len; i++) {
            System.arraycopy(array[i], 0, tmp[i], 0, len);
            tmp[i][len + i] = 1;
        }
        for (int i = 0; i < len; i++) {
            // 找到列主元
            int pivot = i;
            for (int j = i; j < len; j++) {
                if (Math.abs(tmp[j][i]) > Math.abs(tmp[pivot][i])) {
                    pivot = j;
                }
            }
            // 将行交换到最上面
            double[] tmpRow = tmp[i];
            tmp[i] = tmp[pivot];
            tmp[pivot] = tmpRow;
            // 归一化主元所在行
            double div = tmp[i][i];
            for (int j = 0; j < 2 * len; j++) {
                tmp[i][j] /= div;
            }
            // 归零主元所在列的其他行
            for (int j = 0; j < len; j++) {
                if (j != i) {
                    double multi = tmp[j][i];
                    for (int k = 0; k < 2 * len; k++) {
                        tmp[j][k] -= multi * tmp[i][k];
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            System.arraycopy(tmp[i], len, inverse[i], 0, len);
        }
        return inverse;
    }

    // 矩阵向量乘积
    private double[] matrixVectorProduct(double[][] array, double[] vector) {
        int length = array.length;
        int width = array[0].length;
        int vectorLength = vector.length;
        if (width != vectorLength) {
            System.err.println("the column number does not match the row number");
            return null;
        }
        double[] result = new double[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                result[i] += array[i][j] * vector[j];
            }
        }
        return result;
    }

    private static class Data {
        private double x;
        private double y;

        public Data(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Data(double[] xs, double y) {
            this.x = xs[0];
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }


    public static void main(String[] args) throws Exception {
        // 生成测试数据
        double[][] data = {
                {1, 2, 3}, {2, 3, 4}, {3, 4, 5}, {4, 5, 6}, {5, 6, 7},
                {6, 7, 8}, {7, 8, 9}, {8, 9, 10}, {9, 10, 11}, {10, 11, 12}
        };
        double[] target = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        // 创建多项式回归模型，训练模型并输出系数
        PolynomialRegression regression = new PolynomialRegression(2);
        for (int i = 0; i < data.length; i++) {
            regression.addData(new PolynomialRegression.Data(data[i], target[i]));
        }
        regression.train();
        double[] coefficients = regression.calculateCoefficients();
        System.out.println("多项式回归系数为：");
        for (int i = 0; i < coefficients.length; i++) {
            System.out.println("w" + i + ": " + coefficients[i]);
        }

        // 预测结果
        double predictResult = regression.predict(7);
        System.out.println("在 x=7 处的预测结果为：" + predictResult);
    }
}