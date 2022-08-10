package interview.multithread.threethread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableDemo {
    public static Object lock = new Object();
    //synchronized关键字实现
    public static class TestDemo implements Runnable {



        private static int count = 0;

        int no;

        public TestDemo(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count > 100) {
                        break;
                    }
                    if (count % 3 == this.no) {
                        System.out.println(this.no + "--->" + count);
                        count++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    //ReentrantLock实现
    public static class TestDemo2 implements Runnable {
        private int no;
        private static ReentrantLock lock = new ReentrantLock();
        private static Condition condition = lock.newCondition();
        private static int count;

        public TestDemo2(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (count > 100) {
                    break;
                } else {
                    if (count % 3 == this.no) {
                        System.out.println(this.no + "-->" + count);
                        count++;
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                condition.signalAll();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TestDemo(0));
        Thread t2 = new Thread(new TestDemo(1));
        Thread t3 = new Thread(new TestDemo(2));
        t1.start();
        t2.start();
        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();
    }
}