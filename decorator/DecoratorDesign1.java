package decorator;

/**
 * 装饰器模版代码
 */
public class DecoratorDesign1 {

    public static void main(String[] args) {
        new DecoratorDesign1().test1();
    }

    private void test1() {
        Component component = new ConcreteComponent();
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(component);
        decoratorA.sampleOperation();
    }

    public interface Component {
        void sampleOperation();
    }

    public class ConcreteComponent implements Component {
        @Override
        public void sampleOperation() {
            // 写相关的业务代码
            System.out.println("具体角色，定义一个将要接收附加责任的类");
        }
    }

    public class Decorator implements Component {
        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void sampleOperation() {
            // 委派给构件
            component.sampleOperation();
        }
    }

    public class ConcreteDecoratorA extends Decorator {

        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        @Override
        public void sampleOperation() {
            // 写相关的业务代码
            super.sampleOperation();
            // 写相关的业务代码
        }
    }
}
