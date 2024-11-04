package decorator;

/**
 * 装饰器模版代码
 */
public class DecoratorDesign3 {

    public static void main(String[] args) {
        new DecoratorDesign3().test1();
    }

    private void test1() {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());
    }

    public interface Coffee {
        double cost();
        String getDescription();
    }

    public class SimpleCoffee implements Coffee {
        public double cost() {
            return 5.0;
        }

        public String getDescription() {
            return "Simple Coffee";
        }
    }

    public abstract class CoffeeDecorator implements Coffee {
        protected Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }

        public double cost() {
            return coffee.cost();
        }

        public String getDescription() {
            return coffee.getDescription();
        }
    }

    public class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        public double cost() {
            return super.cost() + 1.5;
        }

        public String getDescription() {
            return super.getDescription() + ", Milk";
        }
    }

    public class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        public double cost() {
            return super.cost() + 0.5;
        }

        public String getDescription() {
            return super.getDescription() + ", Sugar";
        }
    }

}
