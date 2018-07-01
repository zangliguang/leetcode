package uncomplete.test.dynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandle implements InvocationHandler {
    Object target;

    public MyHandle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(target, args);

    }
}
