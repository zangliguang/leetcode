package interview.designPattern.abstractfatory;

public class FemaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void getSex() {
        System.out.println("FemaleWhiteHuman 生产一个白皮肤美女");
    }
}
