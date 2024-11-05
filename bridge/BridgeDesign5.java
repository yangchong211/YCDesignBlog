package bridge;

public class BridgeDesign5 {

    public static void main(String[] args) {
        new BridgeDesign5().test();
    }

    private void test() {
        Abstraction abstraction = new ConcreteAbstraction();
        Implementation implementationA = new ConcreteImplementationA();
        Implementation implementationB = new ConcreteImplementationB();

        abstraction.setImplementation(implementationA);
        abstraction.operation(); // 输出：具体操作

        abstraction.setImplementation(implementationB);
        abstraction.operation(); // 输出：具体操作
    }

    // 抽象部分
    abstract class Abstraction {
        protected Implementation implementation;

        public void setImplementation(Implementation implementation) {
            this.implementation = implementation;
        }

        public abstract void operation();
    }

    // 具体部分
    class ConcreteAbstraction extends Abstraction {
        @Override
        public void operation() {
            System.out.println("具体操作");
        }
    }

    // 实现部分
    interface Implementation {
        void operationImpl();
    }

    class ConcreteImplementationA implements Implementation {
        @Override
        public void operationImpl() {
            System.out.println("实现A的操作");
        }
    }

    class ConcreteImplementationB implements Implementation {
        @Override
        public void operationImpl() {
            System.out.println("实现B的操作");
        }
    }

}
