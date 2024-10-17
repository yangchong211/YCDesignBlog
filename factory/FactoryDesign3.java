package factory;

/**
 * 简单工厂
 */
public class FactoryDesign3 {

    public static void main(String[] args) {
        FactoryDesign3 factoryDesign1 = new FactoryDesign3();
        factoryDesign1.test();
    }

    private void test() {
        // 创建意大利风味甜品工厂对象
        // 该工厂生产拿铁咖啡 和提拉米苏
        ItalyDessertFactory factory = new ItalyDessertFactory();
        // 获取拿铁咖啡
        Coffee coffee = factory.createCoffee();
        System.out.println(coffee.getName());//拿铁咖啡
        // 获取提拉米苏
        Dessert dessert = factory.createDessert();
        dessert.show();//提拉米苏...


        // 创建美式风味的甜品工厂对象
        //该工厂生产美式咖啡 和抹茶慕斯
        AmericanDessertFactory factory1 = new AmericanDessertFactory();
        // 获取美式咖啡
        Coffee coffee1 = factory1.createCoffee();
        System.out.println(coffee1.getName());//美式咖啡
        // 获取抹茶慕斯
        Dessert dessert1 = factory1.createDessert();
        dessert1.show();//抹茶慕斯...
    }

    //抽象工厂

    // 综合工厂 生产咖啡类  生产甜品类
    public interface DessertFactory {

        // 生产咖啡
        Coffee createCoffee();

        // 生产甜品
        Dessert createDessert();
    }

    //具体工厂
    // 意大利风味甜品工厂
    // 生产拿铁咖啡和提拉米苏甜品
    public class ItalyDessertFactory implements DessertFactory{
        // 生产拿铁咖啡
        @Override
        public Coffee createCoffee() {
            return new LatteCoffee();
        }
        // 生产提拉米苏
        @Override
        public Dessert createDessert() {
            return new Tiramisu();
        }
    }

    //具体工厂
    // 美式风味的甜品工厂
    // 生美式咖啡 和 抹茶慕斯
    public class AmericanDessertFactory implements DessertFactory{
        // 生产美式咖啡
        @Override
        public Coffee createCoffee() {
            return new AmericanCoffee();
        }

        // 生产抹茶慕斯
        @Override
        public Dessert createDessert() {
            return new MatchaMousse();
        }
    }


    /**---------------------------------------------------------------------------------------------------------*/


    // 抽象甜品类
    public abstract class Dessert {
        // 定义展示具体甜品的规范
        public abstract void show();
    }
    // 具体甜品--提拉米苏类 继承 抽象甜品类
    public class Tiramisu extends Dessert{
        @Override
        public void show() {
            System.out.println("提拉米苏...");
        }
    }
    // 具体甜品--抹茶慕斯类  继承 抽象甜品类
    public class MatchaMousse extends Dessert {
        @Override
        public void show() {
            System.out.println("抹茶慕斯...");
        }
    }


    /**---------------------------------------------------------------------------------------------------------*/

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
