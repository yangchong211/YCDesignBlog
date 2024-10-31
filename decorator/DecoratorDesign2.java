package decorator;

/**
 * 装饰器模版代码
 */
public class DecoratorDesign2 {

    public static void main(String[] args) {
        new DecoratorDesign2().test1();
    }

    private void test1() {
        TheGreatestSage sage = new Monkey();
        // 第一种写法  单层装饰
        TheGreatestSage bird = new Bird(sage);
        TheGreatestSage fish = new Fish(bird);
        // 第二种写法 双层装饰
        //TheGreatestSage fish = new Fish(new Bird(sage));
        fish.move();
    }

    public interface TheGreatestSage {
        void move();
    }

    public class Monkey implements TheGreatestSage {

        @Override
        public void move() {
            //代码
            System.out.println("Monkey Move");
        }
    }

    public class Change implements TheGreatestSage {
        private TheGreatestSage sage;

        public Change(TheGreatestSage sage){
            this.sage = sage;
        }
        @Override
        public void move() {
            // 代码
            sage.move();
        }
    }

    public class Fish extends Change {

        public Fish(TheGreatestSage sage) {
            super(sage);
        }

        @Override
        public void move() {
            // 代码
            System.out.println("Fish Move");
        }
    }

    public class Bird extends Change {

        public Bird(TheGreatestSage sage) {
            super(sage);
        }

        @Override
        public void move() {
            // 代码
            System.out.println("Bird Move");
        }
    }

}
