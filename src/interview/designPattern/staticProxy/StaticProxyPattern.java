package interview.designPattern.staticProxy;

public class StaticProxyPattern {
    public static void main(String[] args) {
//        GamePlayer gamePlayer = new GamePlayer("jordan");
//        gamePlayer.login("jordan","jjj");
//        gamePlayer.killBoss();
//        gamePlayer.upgrade();

        GamePlayer gamePlayer = new GamePlayer("jordan");
// 游戏代练者，需要以游戏玩家的身份玩游戏
        GamePlayProxy gamePlayProxy =new GamePlayProxy(gamePlayer);

        gamePlayProxy.login("jordan","jjj");
        gamePlayProxy.killBoss();
        gamePlayProxy.upgrade();
    }
}
