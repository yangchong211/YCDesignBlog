package strategy;

public class StrategyDesign2 {


    public static void main(String[] args) {
        new StrategyDesign2().test();
    }

    private void test() {
        calcPrice(2,300);
    }

    //将策略的定义、创建、使用直接耦合在一起。
    private void calcPrice(int type,double booksPrice) {
        double price;
        if (type == 1) {
            price = booksPrice * 0.9;
            System.out.println("对中级会员提供10%的促销折扣");
        } else if (type == 2) {
            price = booksPrice * 0.8;
            System.out.println("对高级会员提供20%的促销折扣");
        } else if (type == 3) {
            price = booksPrice * 0.7;
            System.out.println("对钻石会员提供30%的促销折扣");
        } else {
            System.out.println("对初级会员没有折扣");
            price = booksPrice;
        }
        System.out.println("图书的最终价格为：" + price);
    }

}
