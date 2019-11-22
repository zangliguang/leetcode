package uncomplete.test.single;

import java.util.LinkedHashMap;

public class Singleton {
    public Singleton() {
    }

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }


        return instance;
    }
}