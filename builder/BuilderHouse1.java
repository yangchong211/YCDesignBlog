package builder;

/**
 * 使用builder模式不同的房子
 */
public class BuilderHouse1 {

    public static void main(String[] args) {
        BuilderHouse1 builderHouse1 = new BuilderHouse1();
        builderHouse1.test();
    }


    private void test() {
        ///盖普通房子
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(new CommonHouse());
        //完成盖房子，返回产品(普通房子)
        House commonHouse = houseDirector.constructHouse();
        System.out.println("普通房子：" + commonHouse.toString());
        ///盖高楼
        //重置建造者，改成修高楼
        houseDirector.setHouseBuilder(new HighBuilding());
        //完成盖房子，返回产品(高楼)
        House highBuilding = houseDirector.constructHouse();
        System.out.println("高楼：" + highBuilding.toString());
    }

    /**
     * 产品->Product
     */
    public class House {
        private String basic;
        private String wall;
        private String roofed;

        public String getBasic() {
            return basic;
        }

        public void setBasic(String basic) {
            this.basic = basic;
        }

        public String getWall() {
            return wall;
        }

        public void setWall(String wall) {
            this.wall = wall;
        }

        public String getRoofed() {
            return roofed;
        }

        public void setRoofed(String roofed) {
            this.roofed = roofed;
        }

        public House(String basic, String wall, String roofed) {
            this.basic = basic;
            this.wall = wall;
            this.roofed = roofed;
        }

        public House() {
        }

        @Override
        public String toString() {
            return "House{" +
                    "basic='" + basic + '\'' +
                    ", wall='" + wall + '\'' +
                    ", roofed='" + roofed + '\'' +
                    '}';
        }
    }

    /**
     * 抽象的建造者
     */
    public abstract class HouseBuilder {
        /**
         * 组合House
         */
        protected House house = new House();

        //-------------------------将建造的流程写好--------------------------

        /**
         * 打地基
         */
        public abstract void buildBasic();

        /**
         * 砌墙
         */
        public abstract void buildWalls();

        /**
         * 封顶
         */
        public abstract void roofed();

        /**
         * 建造好房子后将产品(房子) 返回
         *
         * @return
         */
        public House buildHouse() {
            return house;
        }
    }


    /**
     * 具体建造者
     */
    public class CommonHouse extends HouseBuilder {

        @Override
        public void buildBasic() {
            System.out.println("普通房子打地基5米 ");
            super.house.setBasic("地基5米");
        }

        @Override
        public void buildWalls() {
            System.out.println("普通房子砌墙10cm ");
            super.house.setWall("墙10cm");
        }

        @Override
        public void roofed() {
            System.out.println("普通房子屋顶 ");
            super.house.setRoofed("普通房子屋顶");
        }

    }

    /**
     * 具体建造者
     */
    public class HighBuilding extends HouseBuilder {

        @Override
        public void buildBasic() {
            System.out.println("高楼的打地基100米 ");
            super.house.setBasic("地基100米");
        }

        @Override
        public void buildWalls() {
            System.out.println("高楼的砌墙20cm ");
            super.house.setWall("墙20cm");
        }

        @Override
        public void roofed() {
            System.out.println("高楼的透明屋顶 ");
            super.house.setRoofed("透明屋顶");
        }
    }


    /**
     * 指挥者，调用制作方法，返回产品
     */
    public class HouseDirector {
        /**
         * 聚合
         */
        HouseBuilder houseBuilder = null;

        /**
         * 方式一：构造器传入 houseBuilder
         *
         * @param houseBuilder
         */
        public HouseDirector(HouseBuilder houseBuilder) {
            this.houseBuilder = houseBuilder;
        }

        /**
         * 方式二：通过setter 传入 houseBuilder
         *
         * @param houseBuilder
         */
        public void setHouseBuilder(HouseBuilder houseBuilder) {
            this.houseBuilder = houseBuilder;
        }

        /**
         * 指挥者统一管理建造房子的流程
         *
         * @return
         */
        public House constructHouse() {
            houseBuilder.buildBasic();
            houseBuilder.buildWalls();
            houseBuilder.roofed();
            return houseBuilder.buildHouse();
        }
    }


}
