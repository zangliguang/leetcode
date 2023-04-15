package machineLearn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 朴素贝叶斯
 * 在这个示例中，我们首先定义了训练数据的格式，即每行第一个单词表示该样本所属的类别（"spam" 或 "ham"），然后是空格分隔的一组单词。
 * 然后，我们使用 train 方法对朴素贝叶斯分类器进行训练。
 * 其中，我们将训练数据存储为两个 Map，分别是 spamWordCount 和 hamWordCount，用于统计每个词在 spam 和 ham 类别下出现的次数。
 * 我们还统计了在 spam 和 ham 类别下出现的单词总数，分别是 totalSpamWords 和 totalHamWords。
 * 在 predictClass 方法中，我们计算了文本属于 spam 和 ham 两个类别的概率，然后返回具有最高概率的类别。
 */
public class NaiveBayes {

    private static final String CLASS_SPAM = "spam";
    private static final String CLASS_HAM = "ham";

    private Map<String, Integer> spamWordCount = new HashMap<>();
    private Map<String, Integer> hamWordCount = new HashMap<>();

    private int countSpam = 0;
    private int countHam = 0;
    private int totalSpamWords = 0;
    private int totalHamWords = 0;

    public void train(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s");
            String className = words[0];
            Map<String, Integer> wordCount = className.equals(CLASS_SPAM) ? spamWordCount : hamWordCount;
            for (int i = 1; i < words.length; i++) {
                String word = words[i].toLowerCase();
                if (!wordCount.containsKey(word)) {
                    wordCount.put(word, 0);
                }
                wordCount.put(word, wordCount.get(word) + 1);
            }
            if (className.equals(CLASS_SPAM)) {
                countSpam++;
            } else {
                countHam++;
            }
        }
        reader.close();
        for (int count : spamWordCount.values()) {
            totalSpamWords += count;
        }
        for (int count : hamWordCount.values()) {
            totalHamWords += count;
        }
    }

    public String predictClass(String text) {
        double probSpam = computeClassProb(text, CLASS_SPAM);
        double probHam = computeClassProb(text, CLASS_HAM);
        return probSpam > probHam ? CLASS_SPAM : CLASS_HAM;
    }

    private double computeClassProb(String text, String className) {
        double prob = className.equals(CLASS_SPAM) ? countSpam / (double) (countSpam + countHam) : countHam / (double) (countSpam + countHam);
        Map<String, Integer> wordCount = className.equals(CLASS_SPAM) ? spamWordCount : hamWordCount;
        int totalWords = className.equals(CLASS_SPAM) ? totalSpamWords : totalHamWords;
        String[] words = text.split("\\s");
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                prob *= (wordCount.get(word) + 1) / (double) (totalWords + wordCount.size());
            } else {
                prob *= 1 / (double) (totalWords + wordCount.size());
            }
        }
        return prob;
    }

    public static void main(String[] args) throws IOException {
        NaiveBayes classifier = new NaiveBayes();
        classifier.train("src/machineLearn/NaiveBayes.java");

        System.out.println("Prediction for 'buy cheap viagra': " + classifier.predictClass("buy cheap viagra"));
        System.out.println("Prediction for 'what are you doing today': " + classifier.predictClass("what are you doing today"));
    }

}