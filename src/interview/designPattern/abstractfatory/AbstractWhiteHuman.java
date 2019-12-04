package interview.designPattern.abstractfatory;

public abstract class AbstractWhiteHuman implements Human {

        @Override
        public void getColor() {
            System.out.println("AbstractWhiteHuman white");
        }

        @Override
        public void talk() {
            System.out.println("AbstractWhiteHuman talk");
        }
    }