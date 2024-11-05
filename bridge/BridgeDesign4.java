package bridge;

import java.math.BigDecimal;

public class BridgeDesign4 {


    public static void main(String[] args) {
        new BridgeDesign4().test1();
    }

    private void test1() {
        System.out.println("测试场景1: 微信支付、人脸方式.");
        Pay wxpay = new WxPay(new PayFaceMode());
        wxpay.transfer("weixin","10001900",new BigDecimal(100));

        System.out.println();

        System.out.println("测试场景2: 支付宝支付、指纹方式");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("zhifubao","567689999999",new BigDecimal(200));
    }


    /**
     * 支付模式接口
     * 实现化（Implementor）角色
     */
    public interface IPayMode {

        //安全校验功能: 对各种支付模式进行风控校验
        boolean security(String uId);
    }


    /**
     * 密码支付及风控校验
     * 具体实现化（Concrete Implementor）角色
     */
    public class PayCypher implements IPayMode {
        @Override
        public boolean security(String uId) {
            return false;
        }
    }


    /**
     * 刷脸支付及风控校验
     * 具体实现化（Concrete Implementor）角色
     */
    public class PayFaceMode implements IPayMode {
        @Override
        public boolean security(String uId) {
            return true;
        }
    }

    /**
     * 指纹支付及风控校验
     * 具体实现化（Concrete Implementor）角色
     */
    public class PayFingerprintMode implements IPayMode {

        @Override
        public boolean security(String uId) {
            return false;
        }
    }

    /**
     * 支付抽象化类
     * 抽象化（Abstraction）角色
     */
    public abstract class Pay {

        protected IPayMode payMode;

        public Pay(IPayMode payMode){
            this.payMode = payMode;
        }

        //划账功能
        public abstract String transfer(String uId, String tradeId, BigDecimal amount);

    }


    /**
     * 支付渠道-微信
     * 扩展抽象化（RefinedAbstraction）角色
     */
    public class WxPay extends Pay{

        public WxPay(IPayMode payMode) {
            super(payMode);
        }

        @Override
        public String transfer(String uId, String tradeId, BigDecimal amount) {
            System.out.println("微信渠道支付划账开始......");

            //支付方式校验
            boolean security = payMode.security(uId);
            System.out.println("微信渠道支付风险校验: " + uId + " , " + tradeId +" , " + security);

            if(!security){
                System.out.println("微信渠道支付划账失败!");
                return "500";
            }

            System.out.println("微信渠道划账成功! 金额: "+ amount);
            return "200";
        }
    }


    /**
     * 支付渠道--支付宝
     * 扩展抽象化（RefinedAbstraction）角色
     */
    public class ZfbPay extends Pay{

        public ZfbPay(IPayMode payMode) {
            super(payMode);
        }

        @Override
        public String transfer(String uId, String tradeId, BigDecimal amount) {
            System.out.println("支付宝渠道支付划账开始......");

            //支付方式校验
            boolean security = payMode.security(uId);
            System.out.println("支付宝渠道支付风险校验: " + uId + " , " + tradeId +" , " + security);

            if(!security){
                System.out.println("支付宝渠道支付划账失败!");
                return "500";
            }

            System.out.println("支付宝渠道划账成功! 金额: "+ amount);
            return "200";
        }
    }
}
