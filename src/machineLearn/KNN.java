package machineLearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * K-近邻算法实现类
 *
 * 在这个实例中，我们生成了一个包含13个黑色点和7个白色点的数据集，然后通过K值为3的K近邻算法预测了新的点(4.5, 2.5)的颜色。最终，我们得到的预测结果是“预测的点为黑色”，即该点被归为黑色类别。
 */
public class KNN {

    // K值
    private int k;

    // 数据集
    private List<Point> dataSet;

    public KNN(int k, List<Point> dataSet) {
        this.k = k;
        this.dataSet = dataSet;
    }

    /**
     * 预测新的点的分类
     */
    public int predict(Point newPoint) {
        // 求出数据集中所有点到新的点的距离并排序
        List<Point> distances = new ArrayList<>();
        for (Point point : dataSet) {
            distances.add(new Point(point.x - newPoint.x, point.y - newPoint.y, point.color));
        }
        Collections.sort(distances, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return (int)(o1.distance - o2.distance);
            }
        });

        // 选择与新点距离最小的K个点
        int[] count = new int[2];
        for (int i = 0; i < k; i++) {
            int color = distances.get(i).color;
            count[color]++;
        }

        // 统计K个点中占比较多的颜色
        if (count[0] > count[1]) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 点的类
     */
    static class Point {

        double x;
        double y;
        int color; // 0代表黑色，1代表白色
        double distance; // 到新点的距离

        public Point(double x, double y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.distance = Math.sqrt(x * x + y * y); // 计算距离
        }
    }

    public static void main(String[] args) {
        // 生成训练数据
        List<Point> dataSet = new ArrayList<>();
        dataSet.add(new Point(1, 2, 0));
        dataSet.add(new Point(2, 1, 0));
        dataSet.add(new Point(2, 3, 0));
        dataSet.add(new Point(3, 2, 0));
        dataSet.add(new Point(3, 3, 0));
        dataSet.add(new Point(4, 4, 0));
        dataSet.add(new Point(5, 5, 0));
        dataSet.add(new Point(4, 1, 1));
        dataSet.add(new Point(4, 3, 1));
        dataSet.add(new Point(5, 2, 1));
        dataSet.add(new Point(5, 4, 1));
        dataSet.add(new Point(6, 3, 1));
        dataSet.add(new Point(7, 2, 1));
        dataSet.add(new Point(7, 3, 1));

        KNN knn = new KNN(3, dataSet); // 选取K=3
        Point newPoint = new Point(4.5, 2.5, 0); // 预测新的点的分类
        int classify = knn.predict(newPoint);
        if (classify == 0) {
            System.out.println("预测的点为黑色");
        } else {
            System.out.println("预测的点为白色");
        }
    }
}