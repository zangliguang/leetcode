package interview.designPattern.fatory;

/**
     * 步骤四：创建具体工厂类（继承抽象工厂类），定义创建对应具体产品实例的方法；
     */

    public  class HumanFactory extends AbstractHumanFactory {

        @Override
        public <T extends Human> T createHuman(Class<T> tClass) {
            Human human = null;
            try {
                human = (Human) Class.forName(tClass.getName()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (T) human;
        }
    }