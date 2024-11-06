package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CompositeDesign5 {

    public static void main(String[] args) {
        new CompositeDesign5().test();
    }

    private void test() {
        Article smallOneBag = new Bag("1号小袋子");
        smallOneBag.add(new Goods("芒果干", 2, 15.8));
        smallOneBag.add(new Goods("薯片", 1, 9.8));

        Article smallTwoBag = new Bag("2号小袋子");
        smallTwoBag.add(new Goods("山楂", 3, 7.8));
        smallTwoBag.add(new Goods("牛肉脯", 2, 19.8));

        Article mediumBag = new Bag("中袋子");
        mediumBag.add(new Goods("巧克力", 1, 39.8));
        mediumBag.add(smallOneBag);

        Article BigBag = new Bag("大袋子");
        BigBag.add(new Goods("牛奶", 1, 79.8));
        BigBag.add(mediumBag);
        BigBag.add(smallTwoBag);

        System.out.println("打工充选购的商品有：");
        BigBag.show();
        Double sum = BigBag.calculation();
        System.out.println("要支付的总价是：" + sum + "元");
    }

    /**
     * 抽象构件（Component）角色
     */
    public interface Article {

        /**
         * 树枝构件特有的方法： 访问和管理子类的接口  大袋子装小袋子
         */
        void add(Article article);

        /**
         * 计算价格
         */
        Double calculation();

        /**
         * 显示商品
         */
        void show();
    }

    /**
     * 树叶构件: 商品
     */
    public class Goods implements Article {

        /**
         * 商品名称
         */
        private String name;
        /**
         * 购买数量
         */
        private Integer quantity;
        /**
         * 商品单价
         */
        private Double unitPrice;

        public Goods(String name, Integer quantity, Double unitPrice) {
            this.name = name;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        /**
         * 树枝构件特有的方法
         * 在树叶构件中是能空实现或者抛异常
         */
        @Override
        public void add(Article article) {

        }

        @Override
        public Double calculation() {
            return this.unitPrice * this.quantity;
        }

        @Override
        public void show() {
            System.out.println(name + ": (数量：" + quantity + "，单价：" + unitPrice + "元)," +
                    "合计：" + this.unitPrice * this.quantity + "元");
        }
    }

    /**
     * 树枝构件: 袋子
     */
    public class Bag implements Article {

        /**
         * 袋子名字
         */
        private String name;

        public Bag(String name) {
            this.name = name;
        }

        /**
         * 袋子中的商品
         */
        private List<Article> bags = new ArrayList<Article>();

        /**
         * 往袋子中添加袋子或者商品
         */
        @Override
        public void add(Article article) {
            bags.add(article);
        }

        @Override
        public Double calculation() {
            AtomicReference<Double> sum = new AtomicReference<>(0.0);
            bags.forEach(e -> {
                sum.updateAndGet(v -> v + e.calculation());
            });
            return sum.get();
        }

        @Override
        public void show() {
            bags.forEach(Article::show);
        }
    }

}
