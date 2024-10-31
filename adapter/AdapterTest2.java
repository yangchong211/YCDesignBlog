package adapter;

public class AdapterTest2 {


    public static void main(String[] args) {

    }

    // 对象适配器：基于组合
    public interface ITarget {
        void f1();

        void f2();

        void fc();
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

    public class Adaptor implements ITarget {
        private final Adaptee adaptee;

        public Adaptor(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        public void f1() {
            adaptee.fa(); //委托给Adaptee
        }

        public void f2() {
            //...重新实现f2()...
        }

        public void fc() {
            adaptee.fc();
        }
    }


}
