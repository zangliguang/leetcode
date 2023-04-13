package machineLearn;

import java.util.*;

/**
 * 首先，我们创建了一个calculateEntropy函数来计算给定数据的信息熵。该函数使用一个Map来记录每个数据出现的次数，并使用公式来计算熵值（注意分子和分母都要使用对数函数）
 *
 *
 * 信息熵（Entropy）是信息论中的一个概念，通常用于衡量一个随机变量的不确定性。在决策树算法中，信息熵被用作一种度量样本集合纯度的方法。
 *
 * 若离散随机变量X的取值为{x1, x2, ..., xn}，概率分布为P(X = xi)，则随机变量X的信息熵定义为：
 *
 * H(X) = - ∑ P(xi) * log2 P(xi)
 *
 * 其中，∑表示在xi取遍所有可能取值时求和。
 *
 * 信息熵的单位是比特（bit），表示样本集合中每个样本所包含的信息量的期望值。信息熵越小，样本集合中的纯度越高，反之则越低。
 *
 * 在决策树算法中，我们希望通过选择最佳分裂属性来使得样本集合的信息熵下降得最快，从而使得决策树生长得最快和最准。因此，决策树算法的核心思想就是通过递归的方式将样本集合不断地细分成子集，直到子集中的所有样本属于同一类别为止。。
 */
public class EntropyCalculator {
    public static double calculateEntropy(List<Integer> data) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int d : data) {
            countMap.put(d, countMap.getOrDefault(d, 0) + 1);
        }

        double entropy = 0;
        for (int count : countMap.values()) {
            double p = (double) count / data.size();
            entropy -= p * Math.log(p) / Math.log(2);
        }

        return entropy;
    }

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1, 2, 1, 3, 2, 3, 3, 3);
        double entropy = calculateEntropy(data);
        System.out.println(entropy);
    }
}