package facade;

public class FacadeDesign1 {

    public static void main(String[] args) {
        new FacadeDesign1().test();
    }

    private void test() {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }

    public interface Shape {
        void draw();
    }

    public class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("Rectangle::draw()");
        }
    }

    public class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("Square::draw()");
        }
    }

    public class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Circle::draw()");
        }
    }

    public class ShapeMaker {
        private Shape circle;
        private Shape rectangle;
        private Shape square;

        public ShapeMaker() {
            circle = new Circle();
            rectangle = new Rectangle();
            square = new Square();
        }

        public void drawCircle(){
            circle.draw();
        }
        public void drawRectangle(){
            rectangle.draw();
        }
        public void drawSquare(){
            square.draw();
        }
    }

}
