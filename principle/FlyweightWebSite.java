package principle;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 接单做网站：要求做产品展示网站，有的人希望是新闻发布形式的，有的人希望是博客形式的，也有还是原来的产品图片加说明形式的。
 * 因为他们找我们来做的人的需求只是有一些小小的差别。
 * 但是不可能有100家企业来找你做网站，你难道去申请100个服务器，用100个数据库，然后用类似的代码复制100遍，去实现吗？
 */
public class FlyweightWebSite {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        WebSite fx = new WebSite("产品展示");
        fx.use();
        WebSite fy = new WebSite("产品展示");
        fy.use();
        WebSite fz = new WebSite("产品展示");
        fz.use();
        WebSite fl = new WebSite("博客");
        fl.use();
        WebSite fm = new WebSite("博客");
        fm.use();
        WebSite fn = new WebSite("博客");
        fn.use();
    }

    //网站
    public static class WebSite {
        private String name = "";

        public WebSite(String name) {
            this.name = name;
        }

        public void use() {
            System.out.println("网站分类：" + name);
        }
    }

    /*---------------------使用享元模式做的第一版网站--------------------------------------------*/
    public static void test2() {
        System.out.println("使用享元模式做的第一版网站");
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        AbsWebSite siteCategory = webSiteFactory.getWebSiteCategory("产品展示");
        siteCategory.use();
        AbsWebSite siteCategory1 = webSiteFactory.getWebSiteCategory("产品展示");
        siteCategory1.use();
        AbsWebSite siteCategory2 = webSiteFactory.getWebSiteCategory("产品展示");
        siteCategory2.use();
        AbsWebSite siteCategory3 = webSiteFactory.getWebSiteCategory("博客");
        siteCategory3.use();
        AbsWebSite siteCategory4 = webSiteFactory.getWebSiteCategory("博客");
        siteCategory4.use();
        AbsWebSite siteCategory5 = webSiteFactory.getWebSiteCategory("博客");
        siteCategory5.use();
        System.out.println("总共创建了 " + webSiteFactory.getWebSiteCount() + " 个实例");
    }

    /**
     * 网站抽象类
     */
    public abstract static class AbsWebSite {
        public abstract void use();
    }

    /**
     * 具体网站类
     */
    public static class ConcreteWebSite extends AbsWebSite {
        private String name = "";

        public ConcreteWebSite(String name) {
            this.name = name;
        }

        @Override
        public void use() {
            System.out.println("网站分类：" + name);
        }
    }

    /**
     * 网站工厂类
     */
    public static class WebSiteFactory {
        private Hashtable<String, AbsWebSite> flyweights = new Hashtable<>();

        /**
         * 获得网站分类
         *
         * @param key key
         * @return AbsWebSite
         */
        public AbsWebSite getWebSiteCategory(String key) {
            if (!flyweights.contains(key)) {
                flyweights.put(key, new ConcreteWebSite(key));
            }
            return flyweights.get(key);
        }

        /**
         * 获得网站实例个数
         *
         * @return 数量
         */
        public int getWebSiteCount() {
            return flyweights.size();
        }
    }

    /*---------------------使用享元模式做的第一版网站--------------------------------------------*/

    public static void test3() {
        System.out.println("使用享元模式做的第二版网站，添加外部状态");
        WebSiteFactory2 webSiteFactory = new WebSiteFactory2();
        AbsWebSite2 siteCategory = webSiteFactory.getWebSiteCategory("产品展示");
        siteCategory.use(new User("打工充0"));
        AbsWebSite2 siteCategory1 = webSiteFactory.getWebSiteCategory("产品展示");
        siteCategory1.use(new User("打工充1"));
        AbsWebSite2 siteCategory2 = webSiteFactory.getWebSiteCategory("产品展示");
        siteCategory2.use(new User("打工充2"));
        AbsWebSite2 siteCategory3 = webSiteFactory.getWebSiteCategory("博客");
        siteCategory3.use(new User("打工充3"));
        AbsWebSite2 siteCategory4 = webSiteFactory.getWebSiteCategory("博客");
        siteCategory4.use(new User("打工充4"));
        AbsWebSite2 siteCategory5 = webSiteFactory.getWebSiteCategory("博客");
        siteCategory5.use(new User("打工充5"));
        System.out.println("总共创建了 " + webSiteFactory.getWebSiteCount() + " 个实例");
    }
    /**
     * 用户类，用于网站的客户账号，是"网站"类的外部状态。
     */
    public static class User {
        private String name;
        public User(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    /**
     * 网站抽象类
     */
    public abstract static class AbsWebSite2 {
        public abstract void use(User user);
    }
    public static class ConcreteWebSite2 extends AbsWebSite2 {
        private String name = "";
        public ConcreteWebSite2(String name) {
            this.name = name;
        }
        @Override
        public void use(User user) {
            System.out.println("网站分类：" + name + " 来自客户：" + user.getName() + "的需求");
        }
    }
    /**
     * 网站工厂类
     */
    public static class WebSiteFactory2 {
        private final HashMap<String, AbsWebSite2> flyweights = new HashMap<>();

        /**
         * 获得网站分类
         *
         * @param key key
         * @return AbsWebSite
         */
        public AbsWebSite2 getWebSiteCategory(String key) {
            if (!flyweights.containsKey(key)) {
                flyweights.put(key, new ConcreteWebSite2(key));
            }
            return flyweights.get(key);
        }

        /**
         * 获得网站实例个数
         *
         * @return 数量
         */
        public int getWebSiteCount() {
            return flyweights.size();
        }
    }
}
