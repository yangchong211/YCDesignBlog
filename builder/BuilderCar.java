/*
package builder;

*/
/**
 * 使用builder模式构造汽车
 *//*

public class BuilderCar {

    public static void main(String[] args) {

    }

    public abstract class Car {
        */
/**
         * 汽车引擎，实际应用中应该是一个对象，这里用字符串来表示
         *//*

        public String engine;

        */
/**
         * 汽车玻璃，不同的汽车大小不一样，需要根据汽车的型号计算
         *//*

        public double glass;

        */
/**
         * 汽车方向盘
         *//*

        public String steeringWheel;

        public abstract void drive();

    }

    */
/**
     * 抽象建造类，提供创建产品的共同接口，不同的产品可以有自己的具体实现
     * @author
     *
     *//*

    public abstract class AbstractBuilder {

        */
/**
         * 创建引擎
         *//*

        public abstract void buildEngine();

        */
/**
         * 创建车玻璃
         *//*

        public abstract void buildGlass();

        */
/**
         * 创建方向盘
         *//*

        public abstract void buildSteeringWheel();

        */
/**
         * 返回创建好的产品，为了兼容所有的产品，返回的类型定为共同的父类
         * @return
         *//*

        public abstract Car getCar();
    }


    public class AudiBuilder extends AbstractBuilder{

        */
/**
         * 创建一个各部分都为空的对象
         *//*

        Audi audi = new Audi();

        */
/**
         * 创建各个部分
         *//*

        public void buildEngine() {
            audi.engine = "AudiEngine";
        }

        public void buildGlass() {
            audi.glass = 3.5;
        }

        public void buildSteeringWheel() {
            audi.steeringWheel = "AudiSteeringWheel";
        }

        */
/**
         * 返回创建好的对象
         *//*

        public Car getCar() {
            return audi;
        }

    }
}
*/
