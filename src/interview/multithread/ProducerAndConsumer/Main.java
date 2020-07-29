package interview.multithread.ProducerAndConsumer;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread p1 = new Thread(new Producer(storage,"producer1"));
        Thread p2 = new Thread(new Producer(storage,"producer2"));
        Thread p3 = new Thread(new Producer(storage,"producer3"));

        Thread c1 = new Thread(new Consumer(storage,"consumer1"));
        Thread c2 = new Thread(new Consumer(storage,"consumer2"));
        Thread c3 = new Thread(new Consumer(storage,"consumer3"));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}