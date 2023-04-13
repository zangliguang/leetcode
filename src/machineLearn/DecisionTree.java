package machineLearn;

import java.util.*;

/**
 * 决策树算法实现类
 *
 * 在这个示例中，我们通过构建决策树来预测用户是否喜欢某一类型的电影。
 * 首先，我们根据电影类型和票房高低生成了一个包含4个样本的训练数据集，并通过决策树算法建立了一棵决策树。
 * 然后，我们通过将用户输入的电影类型和票房信息转化为一个样本数据，使用构建好的决策树来预测用户是否喜欢该类型的电影。
 * 注意：以上示例只是一个非常简单的决策树示例，实际应用中有很多需要考虑的因素。
 */
public class DecisionTree {

    // 构建决策树
    public TreeNode build(List<Sample> samples, List<String> attributes) {
        if (samples.isEmpty()) {
            return new TreeNode(getMostClass(samples));
        }

        int classCount = getClassCount(samples);
        if (classCount == 1) {
            return new TreeNode(samples.get(0).targetValue);
        }

        if (attributes.isEmpty()) {
            return new TreeNode(getMostClass(samples));
        }

        // 选择最佳分裂属性作为根节点
        String bestAttribute = getBestAttribute(samples, attributes);
        TreeNode root = new TreeNode(bestAttribute);

        List<String> subAttributes = new ArrayList<>(attributes);
        subAttributes.remove(bestAttribute);

        // 根据最佳分裂属性的值进行子节点构建
        Map<String, List<Sample>> groupedSamples = groupByAttribute(samples, bestAttribute);
        for (String attributeValue : groupedSamples.keySet()) {
            List<Sample> subSamples = groupedSamples.get(attributeValue);
            TreeNode subNode = build(subSamples, subAttributes);
            root.addChild(attributeValue, subNode);
        }

        return root;
    }

    // 根据测试数据预测类别
    public String predict(TreeNode root, Sample sample) {
        if (root.isLeaf()) {
            return root.label;
        }

        String attributeValue = sample.getAttributeValue(root.label);
        TreeNode subNode = root.getChild(attributeValue);

        if (subNode == null) {
            return getMostClass(root.samples);
        }

        return predict(subNode, sample);
    }

    // 获取类别数量
    private int getClassCount(List<Sample> samples) {
        Set<String> classSet = new HashSet<>();
        for (Sample sample : samples) {
            classSet.add(sample.targetValue);
        }
        return classSet.size();
    }

    // 获取数量最多的类别
    private String getMostClass(List<Sample> samples) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Sample sample : samples) {
            String targetValue = sample.targetValue;
            countMap.put(targetValue, countMap.getOrDefault(targetValue, 0) + 1);
        }

        String mostClass = null;
        int maxCount = -1;
        for (String targetValue : countMap.keySet()) {
            int count = countMap.get(targetValue);
            if (count > maxCount) {
                mostClass = targetValue;
                maxCount = count;
            }
        }

        return mostClass;
    }

    // 根据属性值对样本进行分组
    private Map<String, List<Sample>> groupByAttribute(List<Sample> samples, String attribute) {
        Map<String, List<Sample>> groupMap = new HashMap<>();
        for (Sample sample : samples) {
            String attributeValue = sample.getAttributeValue(attribute);
            List<Sample> list = groupMap.getOrDefault(attributeValue, new ArrayList<>());
            list.add(sample);
            groupMap.put(attributeValue, list);
        }
        return groupMap;
    }

    // 获取最佳分裂属性
    private String getBestAttribute(List<Sample> samples, List<String> attributes) {
        double entropy = calcEntropy(samples);
        double bestGain = 0;
        String bestAttribute = null;

        for (String attribute : attributes) {
            double gain = entropy - calcConditionalEntropy(samples, attribute);
            if (gain > bestGain) {
                bestGain = gain;
                bestAttribute = attribute;
            }
        }

        return bestAttribute;
    }

    // 计算信息熵
    private double calcEntropy(List<Sample> samples) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Sample sample : samples) {
            String targetValue = sample.targetValue;
            countMap.put(targetValue, countMap.getOrDefault(targetValue, 0) + 1);
        }

        double entropy = 0;
        for (String targetValue : countMap.keySet()) {
            double p = (double) countMap.get(targetValue) / samples.size();
            entropy -= p * Math.log(p) / Math.log(2);
        }
        return entropy;
    }

    // 计算条件熵
    private double calcConditionalEntropy(List<Sample> samples, String attribute) {
        double condEntropy = 0;
        Map<String, List<Sample>> groupMap = groupByAttribute(samples, attribute);
        for (List<Sample> groupSamples : groupMap.values()) {
            double p = (double) groupSamples.size() / samples.size();
            condEntropy += p * calcEntropy(groupSamples);
        }
        return condEntropy;
    }

    // 样本类
    static class Sample {
        Map<String, String> attributes;
        String targetValue;

        public Sample(Map<String, String> attributes, String targetValue) {
            this.attributes = attributes;
            this.targetValue = targetValue;
        }

        public String getAttributeValue(String attribute) {
            return attributes.get(attribute);
        }
    }

    // 决策树节点类
    static class TreeNode {
        String label; // 属性名称或分类
        Map<String, TreeNode> children; // 子节点
        List<Sample> samples; // 节点包含的样本数据

        public TreeNode(String label) {
            this.label = label;
            this.children = new HashMap<>();
            this.samples = new ArrayList<>();
        }

        public void addChild(String attributeValue, TreeNode node) {
            children.put(attributeValue, node);
        }

        public TreeNode getChild(String attributeValue) {
            return children.get(attributeValue);
        }

        public void addSample(Sample sample) {
            samples.add(sample);
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }
    }

    public static void main(String[] args) {
        // 生成训练数据
        List<Sample> samples = new ArrayList<>();
        Map<String, String> data1 = new HashMap<>();
        data1.put("类型", "喜剧");
        data1.put("票房", "较高");
        samples.add(new Sample(data1, "是"));

        Map<String, String> data2 = new HashMap<>();
        data2.put("类型", "爱情");
        data2.put("票房", "较高");
        samples.add(new Sample(data2, "是"));

        Map<String, String> data3 = new HashMap<>();
        data3.put("类型", "恐怖");
        data3.put("票房", "较低");
        samples.add(new Sample(data3, "否"));

        Map<String, String> data4 = new HashMap<>();
        data4.put("类型", "恐怖");
        data4.put("票房", "较高");
        samples.add(new Sample(data4, "否"));

        // 建立决策树
        List<String> attributes = new ArrayList<>();
        attributes.add("类型");
        attributes.add("票房");
        DecisionTree decisionTree = new DecisionTree();
        TreeNode root = decisionTree.build(samples, attributes);

        // 预测新数据
        Map<String, String> newData = new HashMap<>();
        newData.put("类型", "喜剧");
        newData.put("票房", "较高");
        Sample testSample = new Sample(newData, null);
        String result = decisionTree.predict(root, testSample);
        System.out.println("预测结果：" + result);
    }
}