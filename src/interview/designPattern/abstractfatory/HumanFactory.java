package interview.designPattern.abstractfatory;

public interface HumanFactory {
    // 创建白皮肤产品族
    Human createWhiteHuman();
    // 创建黑皮肤产品族
    Human createBlackHuman();
}