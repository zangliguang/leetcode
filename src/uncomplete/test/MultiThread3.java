package uncomplete.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThread3 {

    public static volatile Integer index = 0;

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        final Condition condition1 = lock.newCondition();
        final Condition condition2 = lock.newCondition();
        final Condition condition3 = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
            while (index <= 111) {


                    System.out.print(Thread.currentThread().getName()+":");
                    printIndex();

                    condition1.await();

                    condition2.signal();


            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            while (index <= 111) {
                lock.lock();

                try {
                    System.out.print(Thread.currentThread().getName()+":");
                    printIndex();

                    condition2.await();

                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();

            }

        });

        Thread t3 = new Thread(() -> {
            while (index <= 111) {
                lock.lock();
                try {

                    System.out.print(Thread.currentThread().getName()+":");
                    printIndex();
                    condition3.await();
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();

            }

        });
        t1.start();
        t2.start();
        t3.start();
    }

    private static void printIndex() {
        System.out.println(index);
        index++;
    }

}
