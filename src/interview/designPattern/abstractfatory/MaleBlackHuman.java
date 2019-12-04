package interview.designPattern.abstractfatory;

public class MaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("MaleBlackHuman 生产一个黑皮肤大汉");
    }
}
