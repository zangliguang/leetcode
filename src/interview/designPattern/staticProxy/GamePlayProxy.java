package interview.designPattern.staticProxy;

public class GamePlayProxy implements IGamePlayer{
    private IGamePlayer mIGamePlayer;

    public GamePlayProxy(IGamePlayer iGamePlayer ) {
        this.mIGamePlayer = iGamePlayer;
    }
    // 代练升级
    @Override
    public void login(String name, String password) {
        mIGamePlayer.login(name,password);
    }

    // 代练打怪
    @Override
    public void killBoss() {
        mIGamePlayer.killBoss();
    }

    // 代练升级
    @Override
    public void upgrade() {
        mIGamePlayer.upgrade();
    }
}