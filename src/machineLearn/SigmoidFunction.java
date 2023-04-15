package machineLearn;

/**
 *
 * 在这个例子中，我们定义了一个静态方法 sigmoid()，它接收一个实数 x 作为输入参数，并返回一个实数 y，代表输入数据经过 Sigmoid 函数计算后得到的结果。
 * 具体的计算方式使用了 Math 库中的数学函数 pow() 和 E 常量，表示计算 e 的 x 次幂，以及欧拉常数 e。在 main() 函数中，我们调用 sigmoid() 方法并输出结果。
 */
public class SigmoidFunction {
    public static double sigmoid(double x) {
        double y = 1 / (1 + Math.pow(Math.E, -x));
        return y;
    }

    public static void main(String[] args) {
        double x = 1.0;
        double y = sigmoid(x);
        System.out.println("Sigmoid(" + x + ") = " + y);
    }
}