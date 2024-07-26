package principle;

import java.util.HashMap;

/**
 * 享元模式基本实现，比较官方的demo案例
 */
public class FlyweightDemo {

    public static void main(String[] args) {
        String str1 = "123"; //通过直接量赋值方式，放入字符串常量池
        String str2 = new String("123");//通过new方式赋值方式，不放入字符串常量池。直接在堆内存空间创建一个新的对象
        String str3= str2.intern();
        System.out.println(str1==str2);//false
        System.out.println(str2==str3);//false
        System.out.println(str1==str3);//true


        int extrinsicState = 30;
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweightA = factory.getFlyweight("A");
        flyweightA.operation(--extrinsicState);
        Flyweight flyweightB = factory.getFlyweight("B");
        flyweightB.operation(--extrinsicState);
        Flyweight flyweightC = factory.getFlyweight("C");
        flyweightC.operation(--extrinsicState);

        // 不要共享的
        UnsharedConcreteFlyweight unsharedFly = new UnsharedConcreteFlyweight();
        unsharedFly.operation(--extrinsicState);
    }

    /**
     * Flyweight类是所有具体享元类的超类或接口，通过这个接口， Flyweight可以接受并作用于外部状态。
     */
    public static abstract class Flyweight {
        public abstract void operation(int extrinsicState);
    }

    /**
     * ConcreteFlyweight是继承Flyweight超类或实现Flyweight接口，并为内部状态增加存储空间。
     * 需要共享的具体Flyweight子类
     */
    public static class ConcreteFlyweight extends Flyweight {
        @Override
        public void operation(int extrinsicState) {
            System.out.println("需要共享的具体Flyweight子类：" + extrinsicState);
        }
    }

    /**
     * 需要共享的具体Flyweight子类
     * UnsharedConcreteFlyweight是指那些不需要共享的Flyweight子类。因为Flyweight接口共享成为可能，但它并不强制共享。
     */
    public static class UnsharedConcreteFlyweight extends Flyweight {
        @Override
        public void operation(int extrinsicState) {
            System.out.println("不需要共享的具体Flyweight子类：" + extrinsicState);
        }
    }

    /**
     * 享元工厂
     */
    public static class FlyweightFactory {
        private final HashMap<String, Flyweight> flyweights = new HashMap<>();

        /**
         * 初始化工厂三个实例
         */
        public FlyweightFactory() {
            flyweights.put("A", new ConcreteFlyweight());
            flyweights.put("B", new ConcreteFlyweight());
            flyweights.put("C", new ConcreteFlyweight());
        }

        /**
         * 根据客户端请求，获得已生成的实例
         *
         * @param key key
         * @return Flyweight
         */
        public Flyweight getFlyweight(String key) {
            return flyweights.get(key);
        }
    }
}
