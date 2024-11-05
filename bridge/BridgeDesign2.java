package bridge;

public class BridgeDesign2 {

    public static void main(String[] args) {
        new BridgeDesign2().test();
    }

    private void test() {
        Shape circle = new Circle();
        Shape square = new Square();
        Shape coloredCircle = new Color(circle);
        Shape coloredSquare = new Color(square);
        coloredCircle.draw();
        coloredSquare.draw();
    }

    public abstract class Shape {
        public abstract void draw();
    }

    public class Circle extends Shape {
        @Override
        public void draw() {
            System.out.println("画一个圆形");
        }
    }

    public class Square extends Shape {
        @Override
        public void draw() {
            System.out.println("画一个正方形");
        }
    }


    public class Color extends Shape {
        private Shape shape;

        public Color(Shape shape) {
            this.shape = shape;
        }

        @Override
        public void draw() {
            setColor();
            shape.draw();
            resetColor();
        }

        private void setColor() {
            System.out.println("设置颜色");
        }

        private void resetColor() {
            System.out.println("重置颜色");
        }
    }

}
