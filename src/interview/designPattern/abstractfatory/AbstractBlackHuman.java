package interview.designPattern.abstractfatory;

// 负责人种的公共属性的定义。
public abstract class AbstractBlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("AbstractBlackHuman black");
    }

    @Override
    public void talk() {
        System.out.println("AbstractBlackHuman talk");
    }


}