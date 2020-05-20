package uncomplete.test.dynamicAgent;

import java.lang.reflect.Proxy;

public class TestDynamicAgent {
    public static void main(String[] args) {
        UserListener target = new User();
        MyHandle handle = new MyHandle(target);
        UserListener proxy= (UserListener) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handle);
        System.out.println(proxy.getName());
        System.out.println(proxy.getAge());
    }
}
