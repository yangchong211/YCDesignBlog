package singleton;

/**
 * <pre>
 *     @author yangchong
 *     GitHub : https://github.com/yangchong211/YCCommonLib
 *     email : yangchong211@163.com
 *     time  : 2018/11/9
 *     desc  : 单例模式
 *     revise:
 * </pre>
 */
public class InstanceDesign {

    //饿汉式单例类.在类初始化时，已经自行实例化
    public static class Singleton2 {
        //static修饰的静态变量在内存中一旦创建，便永久存在
        private static final Singleton2 singleton = new Singleton2();

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            return singleton;
        }

        public static void main(String[] args) {
            Singleton2 instance = Singleton2.getInstance();
        }
    }

    public static class Singleton3 {
        private static Singleton3 singleton;
        private Singleton3() {

        }
        public static Singleton3 getInstance() {
            if (singleton == null) {
                singleton = new Singleton3();
            }
            return singleton;
        }

//        public static synchronized Singleton3 getInstance() {
//            if (singleton == null) {
//                singleton = new Singleton3();
//            }
//            return singleton;
//        }

        public static void main(String[] args) {
            Singleton3 instance = Singleton3.getInstance();
        }
    }

    public static class Singleton4 {
        private static volatile Singleton4 singleton;  //静态变量

        private Singleton4() {
            //私有构造函数
        }

        public static Singleton4 getInstance() {
            if (singleton == null) {  //第一层校验
                synchronized (Singleton4.class) {
                    if (singleton == null) {  //第二层校验
                        singleton = new Singleton4();
                    }
                }
            }
            return singleton;
        }

        public static void main(String[] args) {
            Singleton4 instance4 = Singleton4.getInstance();
        }
    }


    public static class Singleton5 {
        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }

        //定义的静态内部类
        private static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();  //创建实例的地方
        }

        public static void main(String[] args) {
            Singleton5 singleton5 = Singleton5.getInstance();
        }
    }


    public static Singleton6 getInstance6(){
        return Singleton6.INSTANCE;
    }

    /**
     * enum枚举类
     */
    public enum Singleton6 {
        /**
         * 单例
         */
        INSTANCE;

        public void whateverMethod() {

        }
    }
}
