package uncomplete.test.dynamicAgent;

public class User implements UserListener {
    @Override
    public String getName() {
        return "名字";
    }

    @Override
    public int getAge() {
        return 10;
    }
}
