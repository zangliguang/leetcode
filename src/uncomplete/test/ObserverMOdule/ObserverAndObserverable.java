package uncomplete.test.ObserverMOdule;

import java.util.ArrayList;
import java.util.List;

public class ObserverAndObserverable {

    public static void main(String[] args) {
        Subject s = new Subject();

        s.register(new Obs(s));
        s.register(() -> System.out.println("内部类：" + s.getState()));
        s.setState(112);
    }

    public static class Subject {

        private List<Observer> observers
                = new ArrayList<>();
        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            notifyAllObservers();
        }

        public void register(Observer observer) {
            observers.add(observer);
        }

        public void notifyAllObservers() {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }

    public interface Observer {
        void update();
    }

    public static class Obs implements Observer {
        Subject subject;

        public Obs(Subject s) {
            subject = s;
        }

        @Override
        public void update() {
            System.out.println("设置了新值：" + subject.getState());
        }
    }
}
