package interview.designPattern.abstractfatory;

public class FemaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("FemaleBlackHuman 生产一个黑皮肤美女");
    }
}
