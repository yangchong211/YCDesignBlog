package bridge;

public class BridgeDesign6 {

    public static void main(String[] args) {
        new BridgeDesign6().test();
    }

    private void test() {
        AbstractShape abstractShape = new Rectangle();
        Shape shapeA = new ShapeImpl();
        Shape shapeB = new ShapeImpl();

        abstractShape.setShape(shapeA);
        abstractShape.draw(); // 输出：绘制形状

        abstractShape.setShape(shapeB);
        abstractShape.draw(); // 输出：绘制形状
    }

    // 接口
    interface Shape {
        void draw();
    }

    // 抽象部分
    abstract class AbstractShape {
        protected Shape shape;

        public void setShape(Shape shape) {
            this.shape = shape;
        }

        public abstract void draw();
    }

    // 具体部分
    class Rectangle extends AbstractShape {
        @Override
        public void draw() {
            shape.draw();
        }
    }

    class Circle extends AbstractShape {
        @Override
        public void draw() {
            shape.draw();
        }
    }

    // 内部类实现接口
    class ShapeImpl implements Shape {
        @Override
        public void draw() {
            System.out.println("绘制形状");
        }
    }

}
