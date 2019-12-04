package interview.designPattern.staticProxy;

public interface IGamePlayer {
    // 登录
    void login(String name, String password);
    // 打怪
    void killBoss();
    // 升级
    void upgrade();
}