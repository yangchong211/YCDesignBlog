package creational;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例设计模式思想解读
 * 博客笔记：https://blog.csdn.net/m0_37700275/article/details/78276558
 */
public class InstanceDesign {

    /**
     * 2.1 为什么要使用单例
     * 一个类只允许创建一个对象（或者实例），那这个类就是一个单例类，这种设计模式就叫作单例设计模式，简称单例模式。
     * 为什么我们需要单例这种设计模式？它能解决哪些问题？接下来我通过两个实战案例来讲解。
     * 第一个是处理资源访问冲突；
     * 第二个是表示全局唯一类；
     */

    public class Logger {
        private final FileWriter writer;

        public Logger() {
            File file = new File("/Users/yangchong/log.txt");
            try {
                //true表示追加写入
                writer = new FileWriter(file, true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void log(String message) {
            try {
                writer.write(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void log2(String message) {
            try {
                //可以保证多线程数据安全
                synchronized (this) {
                    writer.write(message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 2.2 处理资源访问冲突
     */
    public class UserController {
        private final Logger logger = new Logger();

        public void login(String username, String password) {
            // ...省略业务逻辑代码...
            logger.log(username + " logined!");
        }
    }

    public class OrderController {
        private final Logger logger = new Logger();

        public void create(String order) {
            // ...省略业务逻辑代码...
            logger.log("created order: " + order);
        }
    }


    /**
     * 2.3 表示全局唯一类
     */
    public static class IdGenerator {
        private final AtomicLong id = new AtomicLong(0);
        private static final IdGenerator instance = new IdGenerator();

        private IdGenerator() {
        }

        public static IdGenerator getInstance() {
            return instance;
        }

        public long getId() {
            return id.incrementAndGet();
        }
    }

    public void test() {
        // IdGenerator使用举例
        long id = IdGenerator.getInstance().getId();
    }


    /**
     * 3.1 如何实现一个单例
     * 构造函数需要是 private 访问权限的，这样才能避免外部通过 new 创建实例；
     * 考虑对象创建时的线程安全问题；
     * 考虑是否支持延迟加载；
     * 考虑 getInstance() 性能是否高（是否加锁）。
     */

    /**
     * 3.2 饿汉式实现方式
     */
    //饿汉式单例类.在类初始化时，已经自行实例化
    public static class Singleton1 {
        //static修饰的静态变量在内存中一旦创建，便永久存在
        private static final Singleton1 instance = new Singleton1();

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            return instance;
        }
    }

    public void test1() {
        Singleton1 instance = Singleton1.getInstance();
    }

    /**
     * 3.3 懒汉式实现方式
     */

    public static class Singleton2 {
        //私有的构造函数
        private Singleton2() {
        }

        //私有的静态变量
        private static Singleton2 single = null;

        //暴露的公有静态方法
        public static Singleton2 getInstance() {
            if (single == null) {
                single = new Singleton2();
            }
            return single;
        }

        //公有的同步静态方法
        public static synchronized Singleton2 getInstance2() {
            if (single == null) {
                single = new Singleton2();
            }
            return single;
        }
    }

    /**
     * 延迟加载（需要的时候才去加载）
     */
    public void test2() {
        //线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行的频繁读写操作时。
        Singleton2 instance = Singleton2.getInstance();
        //加了一把大锁（synchronized），导致这个函数的并发度很低。
        Singleton2 instance2 = Singleton2.getInstance2();
    }


    /**
     * 3.4 双重DCL校验模式
     */
    public static class Singleton3 {
        /**
         * 因为指令重排序，可能会导致 singleton 对象被 new 出来，并且赋值给 instance 之后，还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。
         * 解决这个问题，需要给 instance 成员变量加上 volatile 关键字，禁止指令重排序才行。
         */
        private volatile static Singleton3 singleton1;  //静态变量
        private static Singleton3 singleton;  //静态变量

        private Singleton3() {
        }  //私有构造函数

        public static Singleton3 getInstance() {
            if (singleton == null) {  //第一层校验
                synchronized (Singleton3.class) {
                    if (singleton == null) {  //第二层校验
                        singleton = new Singleton3();
                    }
                }
            }
            return singleton;
        }
    }

    public void test3() {
        //既支持延迟加载、又支持高并发的单例实现方
        Singleton3 instance = Singleton3.getInstance();
    }

    /**
     * 3.5 静态内部类方式
     */
    public static class Singleton4 {
        private Singleton4() {
        }

        ;//私有的构造函数

        public static final Singleton4 getInstance() {
            return SingletonHolder.INSTANCE;
        }

        //定义的静态内部类
        private static class SingletonHolder {
            private static final Singleton4 INSTANCE = new Singleton4();  //创建实例的地方
        }
    }

    public void test4() {
        Singleton4 instance = Singleton4.getInstance();
    }

    /**
     * 3.6 枚举方式单例
     */

    public enum Singleton5 {  //enum枚举类
        INSTANCE;

        public void test() {
        }
    }

    public void test5() {
        Singleton5 instance = Singleton5.INSTANCE;
    }

    /**
     * 3.7 容器实现单例模式
     */
    public static class SingletonContainer {
        private static final Map<String, Singleton6> container = new HashMap<>();

        private SingletonContainer() {
            // 私有构造函数，防止外部实例化
        }

        public static Singleton6 getInstance(String key) {
            if (!container.containsKey(key)) {
                synchronized (SingletonContainer.class) {
                    if (!container.containsKey(key)) {
                        Singleton6 instance = new Singleton6(); // 根据需要创建实例的方法
                        container.put(key, instance);
                    }
                }
            }
            return container.get(key);
        }

        public static class Singleton6 {

        }
    }

    public void test6() {
        SingletonContainer.Singleton6 instance = SingletonContainer.getInstance("Yc");
    }

}
