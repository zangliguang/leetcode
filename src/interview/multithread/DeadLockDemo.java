package interview.multithread;

import java.util.concurrent.*;

public class DeadLockDemo {
    public static void main(String[] args) {
        String lock1 = "qwqw";
        String lock2 = "fadf";
        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        threadPool.execute(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "\t获得lock1,需要lock2");
                synchronized (lock2) {
                }
            }
        });

        threadPool.execute(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "\t获得lock2,需要lock1");
                synchronized (lock1) {
                }
            }
        });
    }
}