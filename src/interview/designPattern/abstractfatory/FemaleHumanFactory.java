package interview.designPattern.abstractfatory;

// 生产美女的工厂
public class FemaleHumanFactory implements HumanFactory {
    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}

