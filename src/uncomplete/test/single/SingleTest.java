package uncomplete.test.single;

/**
 * Created by zangliguang on 2017/7/4.
 */

class SingleTest {
    private static final SingleTest ourInstance = new SingleTest();

    static SingleTest getInstance() {
        return ourInstance;
    }

    private SingleTest() {
    }
}
