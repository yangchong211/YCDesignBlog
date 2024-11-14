package strategy;

public class StrategyDesign1 {

    public static void main(String[] args) {
        new StrategyDesign1().test();
    }

    private void test() {
        //创建策略
        Strategy strategy = new ConcreteStrategyA();
        //创建环境
        Context context = new Context(strategy);
        //执行行为
        context.algorithm();
    }

    public interface Strategy{
        void algorithm();
    }

    public static class ConcreteStrategyA implements Strategy {
        @Override
        public void algorithm() {
            System.out.println("use algorithm A");
        }
    }

    public static class ConcreteStrategyB implements Strategy {
        @Override
        public void algorithm() {
            System.out.println("use algorithm B");
        }
    }

    public static class Context {
        private final Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void algorithm() {
            strategy.algorithm();
        }
    }


}
