package factory;

/**
 * 简单工厂
 */
public class FactoryDesign1 {

    public static void main(String[] args) {
        FactoryDesign1 factoryDesign1 = new FactoryDesign1();
        factoryDesign1.test();
    }

    private void test() {
        // 创建咖啡店对象，进行点咖啡
        CoffeeStore store = new CoffeeStore();
        //隐含了多态，在工厂里
        Coffee coffee = store.orderCoffee("american");
        String name = coffee.getName();
        System.out.println(name);
        //加糖...
        //加奶...
        //美式咖啡
    }

    // 咖啡店类
    public class CoffeeStore {
        public Coffee orderCoffee(String type) {
            //此处解除了咖啡店类和具体的咖啡类的依赖，降低了耦合
            // 创建工厂对象目的是创建具体的咖啡
            SimpleFactory sf = new SimpleFactory();
            // 创建咖啡，返回具体的咖啡对象
            Coffee coffee = sf.createCoffee(type);
            coffee.addSugar();
            coffee.addMilk();
            // 将具体的咖啡对象返回
            return coffee;
        }
    }

    // 咖啡工厂
    public class SimpleFactory {
        //提供方法,创建具体咖啡
        public Coffee createCoffee(String type) {
            Coffee coffee = null;
            if ("american".equals(type)) {
                coffee = new AmericanCoffee(); //多态
            } else if ("latte".equals(type)) {
                coffee = new LatteCoffee(); //多态
            } else {
                throw new RuntimeException("没有这种咖啡！");
            }

            return null;
        }
    }


    // 咖啡类(父类)--抽象类
    public abstract class Coffee {

        //每个咖啡都有名字，所以抽取到父类，定义为抽象方法
        public abstract String getName();

        public void addMilk() {
            System.out.println("加奶...");
        }

        public void addSugar() {
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
