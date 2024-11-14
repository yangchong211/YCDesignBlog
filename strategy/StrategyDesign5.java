package strategy;

/**
 * 需求1: 假设我们正在开发一个计算器程序，该程序可以根据用户的选择进行加、减、乘、除四种运算。如果是你，你该怎么做？
 */
public class StrategyDesign5 {

    public static void main(String[] args) {
        new StrategyDesign5().test();
    }

    //4.最后，我们可以在客户端代码中使用上述的类来完成计算器的功能：
    private void test() {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationDivide());
        System.out.println("10 / 5 = " + context.executeStrategy(10, 5));
    }

    //在我们将通过代码实现上述的计算器程序，首先我们需要定义一个策略接口，用于声明算法方法：

    public interface Strategy {
        public int doOperation(int num1, int num2);
    }

    //接着，我们需要实现具体的策略类，这些类分别对应加、减、乘、除四种运算：
    public class OperationAdd implements Strategy {
        public int doOperation(int num1, int num2) {
            return num1 + num2;
        }
    }

    public class OperationSubtract implements Strategy {
        public int doOperation(int num1, int num2) {
            return num1 - num2;
        }
    }

    public class OperationMultiply implements Strategy {
        public int doOperation(int num1, int num2) {
            return num1 * num2;
        }
    }

    public class OperationDivide implements Strategy {
        public int doOperation(int num1, int num2) {
            return num1 / num2;
        }
    }

    //接下来，我们需要定义一个环境类，用于持有具体的策略类，并调用其方法：
    public class Context {
        private Strategy strategy;

        public Context(Strategy strategy){
            this.strategy = strategy;
        }

        public int executeStrategy(int num1, int num2){
            return strategy.doOperation(num1, num2);
        }
    }
}
