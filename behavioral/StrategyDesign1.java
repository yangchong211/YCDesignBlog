package behavioral;

/**
 * 策略模式官方demo
 */
public class StrategyDesign1 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Context context = new Context(new ConcreteStrategyA());
        context.algorithm();
        Context contextB = new Context(new ConcreteStrategyB());
        contextB.algorithm();
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
