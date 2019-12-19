package interview.designPattern.abstractfatory;

public class AbstractFacotyPattern {
    /**
     *
     * 优点：
     *
     * ●　1.封装性，降低耦合度：每个产品的实现类不是高层所关心的，只关心抽象和接口，不关心对象如何创建出来，由谁负责。只需知道工厂是谁，就能创建一个对象。
     *
     * ●　2.更符合开闭原则：新增一个产品类时，只需增加相应具体产品类和抽象工厂子类即可。
     *
     * ●　3.更符合单一原则：每个具体工厂类只负责创建相应的产品。
     *
     * 缺点：
     *
     * ●　扩展产品族困难，需要更改的代码太多。如果要增加一个产品 C， 也就是说产品家族由原来的 2 个增加到 3 个，看看我们的程序有多大改动吧！
     *     抽象类 AbstractCreator 要增加一个方法 createProductC()， 然后两个实现类都要修改，想想看，这严重违反了开闭原则，
     *     而且我们一直说明抽象类和接口是一个契约。
     *
     *  注：虽然抽象工厂模式扩展产品族困难，但是扩展产品类别比较容易，
     * @param args
     */
    public static void main(String[] args) {
        // 生产男性的生产线
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();
        // 生产女性的生产线
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        //开始产人
        Human blackHuman = femaleHumanFactory.createBlackHuman();
        blackHuman.getColor();
        blackHuman.talk();
        blackHuman.getSex();

        Human whiteHuman = maleHumanFactory.createWhiteHuman();
        whiteHuman.getColor();
        whiteHuman.talk();
        whiteHuman.getSex();

    }
}
