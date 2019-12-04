package interview.designPattern.dynamicProxy;

import interview.designPattern.staticProxy.GamePlayer;
import interview.designPattern.staticProxy.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class dynamicProxyPattern {
    /**
     * 优点：
     *
     * 1.协调调用者和被调用者，降低了系统的耦合度
     * 2.代理对象作为客户端和目标对象之间的中介，起到了保护目标对象的作用
     * 缺点：
     *
     * 1.由于在客户端和真实主题之间增加了代理对象，因此会造成请求的处理速度变慢；
     * 2.实现代理模式需要额外的工作（有些代理模式的实现非常复杂），从而增加了系统实现的复杂度。
     * @param args
     */
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("jordan");
        InvocationHandler handler = new GamePlayIH(gamePlayer);
        ClassLoader classLoader = gamePlayer.getClass().getClassLoader();
        // 动态的产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, handler);
        // 代替玩家开始犀利的操作
        proxy.login("jordan2","jjj");
        proxy.killBoss();
        proxy.upgrade();

    }

}
