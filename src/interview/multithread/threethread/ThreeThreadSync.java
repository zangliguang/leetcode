package interview.multithread.threethread;

public class ThreeThreadSync {

    static  int parameter = 1;


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (ThreeThreadSync.class){
                    if (parameter % 3 == 1&&parameter<=100) {
                        System.out.println(parameter);
                        parameter++;

                    }
                    if(parameter>100){
                        break;
                    }
                }
            }

        });
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (ThreeThreadSync.class){
                    if (parameter % 3 == 2&&parameter<=100) {
                        System.out.println(parameter);
                        parameter++;

                    }
                    if(parameter>100){
                        break;
                    }

                }

            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {

                synchronized (ThreeThreadSync.class){
                    if (parameter % 3 == 0&&parameter<=100) {
                        System.out.println(parameter);
                        parameter++;

                    }
                    if(parameter>100){
                        break;
                    }
                }


            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
