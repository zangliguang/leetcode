package interview.designPattern.fatory;

public class WhiteHuman implements Human {
        @Override
        public void getColor() {
            System.out.println("WhiteHuman  white");
        }

        @Override
        public void talk() {
            System.out.println("WhiteHuman  talk");
        }
    }