package interview.designPattern.fatory;

/**
     * 步骤三：创建具体产品类（继承抽象产品类）， 定义生产的具体产品
     */

    public class BlackHuman implements Human {
        @Override
        public void getColor() {
            System.out.println("BlackHuman black");
        }

        @Override
        public void talk() {
            System.out.println("BlackHuman talk");
        }
    }