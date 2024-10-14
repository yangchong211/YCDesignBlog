package builder;

/**
 * 使用builder模式不同的房子
 */
public class BuilderHouse2 {

    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
        HeightBuilding heightBuilding = new HeightBuilding();
        heightBuilding.build();
        // 普通房子打地基
        // 普通房子砌墙
        // 普通房子封顶
        // 高楼打地基
        // 高楼房子砌墙
        // 高楼房子封顶
    }

    public static abstract class AbstractHouse {

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

        public void build() {
            buildBasic();
            buildWalls();
            roofed();
        }

    }

    public static class CommonHouse extends AbstractHouse {

        @Override
        public void buildBasic() {
            System.out.println(" 普通房子打地基 ");
        }

        @Override
        public void buildWalls() {
            System.out.println(" 普通房子砌墙 ");
        }

        @Override
        public void roofed() {
            System.out.println(" 普通房子封顶 ");
        }

    }

    public static class HeightBuilding extends AbstractHouse {

        @Override
        public void buildBasic() {
            System.out.println(" 高楼打地基 ");
        }

        @Override
        public void buildWalls() {
            System.out.println(" 高楼房子砌墙 ");
        }

        @Override
        public void roofed() {
            System.out.println(" 高楼房子封顶 ");
        }
    }
}
