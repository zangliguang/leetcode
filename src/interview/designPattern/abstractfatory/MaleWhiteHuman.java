package interview.designPattern.abstractfatory;

public class MaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void getSex() {
        System.out.println("MaleWhiteHuman 生产一个白皮肤大汉");
    }
}
