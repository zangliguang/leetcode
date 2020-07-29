package interview.multithread.ProducerAndConsumer;

public class Consumer implements Runnable{
    private Storage storage;

    public Consumer(){}

    public Consumer(Storage storage , String name){
        this.storage = storage;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(3000);
                storage.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}