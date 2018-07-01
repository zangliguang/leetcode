package uncomplete.test;

import java.util.concurrent.locks.ReentrantLock;

public class MultiThread {

    public static volatile Integer index = 0;

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            while (index <= 111) {
                if (index % 3 == 0) {
                    System.out.println(Thread.currentThread().getName()+"："+index);
                    index++;
                }

            }
        });
        Thread t2 = new Thread(() -> {
            while (index <= 111) {
                if (index % 3 == 1) {
                    System.out.println(Thread.currentThread().getName()+"："+index);
                    index++;
                }

            }

        });
        Thread t3 = new Thread(() -> {
            while (index <= 111) {
                if (index % 3 == 2) {
                    System.out.println(Thread.currentThread().getName()+"："+index);
                    index++;
                }

            }

        });
        t1.start();
        t2.start();
        t3.start();
    }

}
