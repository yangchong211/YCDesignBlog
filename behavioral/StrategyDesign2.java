package behavioral;

/**
 * 策略模式演变过程
 */
public class StrategyDesign2 {

    public static void main(String[] args) {
        test();
    }

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



    private static void test() {
        //选择并创建需要使用的策略对象
        MemberStrategy strategy = new AdvancedMemberStrategy();
        //创建环境
        Price price = new Price(strategy);
        //计算价格
        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);
    }

    public static class Price {
        //持有一个具体的策略对象
        private MemberStrategy strategy;
        /**
         * 构造函数，传入一个具体的策略对象
         * @param strategy    具体的策略对象
         */
        public Price(MemberStrategy strategy){
            this.strategy = strategy;
        }

        /**
         * 计算图书的价格
         * @param booksPrice    图书的原价
         * @return    计算出打折后的价格
         */
        public double quote(double booksPrice){
            return this.strategy.calcPrice(booksPrice);
        }
    }

    public interface MemberStrategy {
        /**
         * 计算图书的价格
         * @param booksPrice    图书的原价
         * @return    计算出打折后的价格
         */
        double calcPrice(double booksPrice);
    }

    public class PrimaryMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            System.out.println("对于初级会员的没有折扣");
            return booksPrice;
        }
    }

    public class IntermediateMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            System.out.println("对于中级会员的折扣为10%");
            return booksPrice * 0.9;
        }

    }

    public static class AdvancedMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            System.out.println("对于高级会员的折扣为20%");
            return booksPrice * 0.8;
        }
    }

    public class SpecialMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            System.out.println("对钻石会员提供30%的促销折扣");
            return booksPrice * 0.7;
        }
    }

}
