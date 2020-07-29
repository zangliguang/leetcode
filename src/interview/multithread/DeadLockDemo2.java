package interview.multithread;

public class DeadLockDemo2 {
    public static void main(String[] args) {
        Object LockA=new Object();
        Object LockB=new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name=Thread.currentThread().getName();
                synchronized (LockA){
                    System.out.println(name+" get LockA want LockB");
                    try{
                        Thread.sleep(100);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (LockB){
                        System.out.println(name + " got lockB");
                        System.out.println(name + ": say Hello!");
                    }
                }
            }
        },"Thread-A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name=Thread.currentThread().getName();
                synchronized (LockB){
                    System.out.println(name+" get LockB want LockA");
                    try{
                        Thread.sleep(100);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (LockA){
                        System.out.println(name + " got lockA");
                        System.out.println(name + ": say Hello!");
                    }
                }
            }
        },"Thread-B").start();
    }
 
 
}