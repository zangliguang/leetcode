package uncomplete;

public class SingleTest2 {
    public SingleTest2() {

    }

    private static class SingleTest2Hold {
        private static final SingleTest2 instance = new SingleTest2();
    }

    public SingleTest2 getInstance() {

        return SingleTest2Hold.instance;
    }


}