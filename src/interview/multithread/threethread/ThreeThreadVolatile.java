package interview.multithread.threethread;

public class ThreeThreadVolatile {

    static volatile int parameter = 1;


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (parameter % 3 == 1&&parameter<=100) {
                    System.out.println(Thread.currentThread().getName()+":"+parameter);
                    parameter++;
                }else if (parameter>100){
                    break;
                }



            }

        });
        Thread t2 = new Thread(() -> {
            while (true) {
                if (parameter % 3 == 2&&parameter<100) {

                    System.out.println(Thread.currentThread().getName()+":"+parameter);
                    parameter++;
                }else if (parameter>100){
                    break;
                }


            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {

                if (parameter % 3 == 0&&parameter<100) {
                    System.out.println(Thread.currentThread().getName()+":"+parameter);
                    parameter++;
                }else if (parameter>100){
                    break;
                }



            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
