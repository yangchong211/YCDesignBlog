package structural;

public class ProxyDesign {

    public static void main(String[] args) {
        testProxy();
        testProxy2();
        proxyImage();
    }

    private static void testProxy() {
        //1.创建委托对象
        RealSubject subject = new RealSubject();
        //2.创建调用处理器对象
        Proxy p = new Proxy(subject);
        //3.通过代理对象调用方法
        p.request();
    }

    private static void testProxy2() {
        //1.创建委托对象
        RealSubject subject = new RealSubject();
        //2.创建调用处理器对象
        MyProxy p = new MyProxy(subject);
        //3.通过代理对象调用方法
        p.request();
    }


    /**
     * 代理类和委托类会实现接口
     */
    interface Subject{
        void request();
    }


    /**
     * 委托类
     */
    static class RealSubject implements Subject{
        @Override
        public void request(){
            System.out.println("request 1");
        }
    }

    /**
     * 委托类
     */
    static class RealSubject2 implements Subject{
        @Override
        public void request(){
            System.out.println("request 2");
        }
    }

    /**
     * 代理类
     */
    static class Proxy implements Subject {

        private Subject subject;
        public Proxy(Subject subject){
            this.subject = subject;
        }

        @Override
        public void request() {
            System.out.println("PreProcess");
            subject.request();
            System.out.println("PostProcess");
        }
    }

    /**
     * 代理类，给委托类增加一个过滤功能，只租房给我们这类逗比程序员。
     * 通过静态代理，我们无需修改委托类的代码就可以实现，只需在代理类中的方法中添加一个判断即可如下所示：
     */
    static class MyProxy implements Subject{
        private Subject subject;
        boolean isDouBi = true;
        public MyProxy(Subject subject){
            this.subject = subject;
        }
        @Override
        public void request(){
            //判断是否是逗比程序员
            if (isDouBi){
                System.out.println("逗比 PreProcess");
                subject.request();
                System.out.println("逗比 PostProcess");
            }
        }
    }

    /*
    * 静态代理可以用于保护真实对象的使用权限
    * 通过代理类，可以在访问真实对象之前或之后执行一些额外的操作，例如权限验证、身份验证等，以确保只有具有适当权限的用户可以访问真实对象。
    * */
    private static void proxyImage() {
        Image image = new ImageProxy("image.jpg");
        // 只有在调用display方法时，真实对象才会被加载和显示
        image.display();
    }


    // 定义接口
    interface Image {
        void display();
    }

    // 定义真实对象
    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading image from disk: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }
    // 定义代理类
    static class ImageProxy implements Image {
        private String filename;
        private RealImage realImage;

        public ImageProxy(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

    /**
     * 以下是一个简单的案例，演示了如何使用静态代理来降低耦合：
     *
     * 假设我们有一个邮件发送的接口 MailSender，以及一个实现该接口的具体类 RealMailSender。
     * 现在我们想要在发送邮件之前记录日志，但又不想直接修改 RealMailSender 类。这时可以使用静态代理来实现：
     */


    // 定义邮件发送接口
    interface MailSender {
        void sendMail(String recipient, String message);
    }

    // 实现邮件发送接口的具体类
    class RealMailSender implements MailSender {
        public void sendMail(String recipient, String message) {
            System.out.println("Sending mail to " + recipient + ": " + message);
        }
    }

    // 静态代理类
    class MailSenderProxy implements MailSender {
        private RealMailSender realMailSender;

        public MailSenderProxy() {
            this.realMailSender = new RealMailSender();
        }

        public void sendMail(String recipient, String message) {
            System.out.println("Logging mail sending...");
            realMailSender.sendMail(recipient, message);
        }
    }

}
