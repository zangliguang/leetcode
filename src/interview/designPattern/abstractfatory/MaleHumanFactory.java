package interview.designPattern.abstractfatory;

// 生产男性的工厂（区分颜色）
public class MaleHumanFactory implements HumanFactory {
    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}