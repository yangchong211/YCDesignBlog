package factory;

/**
 * 简单工厂
 */
public class FactoryDesign2 {

    public static void main(String[] args) {
        FactoryDesign2 factoryDesign1 = new FactoryDesign2();
        factoryDesign1.test();
    }

    private void test() {
        // 创建咖啡店类对象
        CoffeeStore coffeeStore = new CoffeeStore();
        //创建拿铁咖啡工厂，多态
        CoffeeFactory coffeeFactory = new LatteCoffeeFactory();
        //CoffeeFactory amerFactory  = new AmericanCoffeeFactory();
        coffeeStore.setCoffeeFactory(coffeeFactory);
        // 点咖啡
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
    }


    //咖啡店类
    public class CoffeeStore {

        private CoffeeFactory coffeeFactory;

        public void setCoffeeFactory(CoffeeFactory coffeeFactory) {
            this.coffeeFactory = coffeeFactory;
        }

        public Coffee orderCoffee(){
            // 咖啡工厂来创建具体的咖啡
            Coffee coffee = coffeeFactory.creatCoffee();
            // 加配料
            coffee.addMilk();
            coffee.addSugar();
            return coffee;
        }
    }

    // 创建拿铁咖啡工厂类 实现 咖啡工厂类接口
    public class LatteCoffeeFactory implements CoffeeFactory{
        @Override
        public Coffee creatCoffee() {
            return new LatteCoffee();
        }
    }

    // 创建美式咖啡工厂类 实现 咖啡工厂类接口
    public class AmericanCoffeeFactory implements CoffeeFactory {
        @Override
        public Coffee creatCoffee() {
            return new AmericanCoffee();
        }
    }


    // 定义咖啡工厂接口
    public interface CoffeeFactory {
        public abstract Coffee creatCoffee();
    }

    // 咖啡抽象类
    public abstract class Coffee {
        public abstract String getName();

        public void addMilk(){
            System.out.println("加奶...");
        }
        public void addSugar(){
            System.out.println("加糖...");
        }
    }

    // 美式咖啡类 继承 咖啡类
    public class AmericanCoffee extends Coffee {
        @Override
        public String getName() {
            return "美式咖啡";
        }

        public void show() {
            System.out.println("我是美式咖啡....");
        }
    }

    // 拿铁咖啡类 继承 咖啡类
    public class LatteCoffee extends Coffee {
        @Override
        public String getName() {
            return "拿铁咖啡";
        }
    }
}
