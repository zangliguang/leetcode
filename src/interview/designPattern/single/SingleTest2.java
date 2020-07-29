package interview.designPattern.single;

public class SingleTest2 {
    private SingleTest2() {

    }

    private static class SingleTest2Hold {
        private static final SingleTest2 instance = new SingleTest2();
    }

    public static SingleTest2 getInstance() {

        return SingleTest2Hold.instance;
    }


}