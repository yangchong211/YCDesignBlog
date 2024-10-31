package adapter;

public class AdapterTest1 {


    public static void main(String[] args) {

    }

    // 类适配器: 基于继承
    public interface ITarget {
        void f1();

        void f2();

        void f3();
    }

    public class Adaptee {
        public void fa() {
            //...
        }

        public void fb() {
            //...
        }

        public void fc() {
            //...
        }
    }

    public class Adaptor extends Adaptee implements ITarget {
        public void f1() {
            super.fa();
            System.out.println("调用适配器中方法");
        }

        public void f2() {
            //...重新实现f2()...
            super.fb();
            System.out.println("重新实现f2");
        }

        // 这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点
        @Override
        public void f3() {

        }
    }
}
