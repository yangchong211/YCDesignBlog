package proxy;

/**
 * 静态代理模式
 */
public class ProxyDesign1 {

    public static void main(String[] args) {
        new ProxyDesign1().testProxy();
    }

    private void testProxy() {
        //1.创建委托对象
        RealSubject1 subject = new RealSubject1();
        //RealSubject2 subject = new RealSubject2();
        //2.创建调用处理器对象
        Proxy p = new Proxy(subject);
        //3.通过代理对象调用方法
        p.request();
    }


    /**
     * 代理类和委托类会实现接口
     */
    interface Subject {
        void request();
    }


    /**
     * 委托类1
     */
    static class RealSubject1 implements Subject {
        @Override
        public void request() {
            System.out.println("request 1 要找房子");
        }
    }

    /**
     * 委托类1
     */
    static class RealSubject2 implements Subject {
        @Override
        public void request() {
            System.out.println("request 2 要找房子");
        }
    }

    /**
     * 代理类
     */
    static class Proxy implements Subject {

        private Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            System.out.println("代理类");
            subject.request();
        }
    }


    /*
     * 静态代理可以用于保护真实对象的使用权限
     * 通过代理类，可以在访问真实对象之前或之后执行一些额外的操作，例如权限验证、身份验证等，以确保只有具有适当权限的用户可以访问真实对象。
     * */
    private void proxyImage() {
        Image image = new ImageProxy("image.jpg");
        // 只有在调用display方法时，真实对象才会被加载和显示
        image.display();
    }


    // 定义接口
    interface Image {
        void display();
    }

    // 定义真实对象
    public class RealImage implements Image {
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
    public class ImageProxy implements Image {
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
        private final RealMailSender realMailSender;

        public MailSenderProxy() {
            this.realMailSender = new RealMailSender();
        }

        public void sendMail(String recipient, String message) {
            System.out.println("Logging mail sending...");
            realMailSender.sendMail(recipient, message);
        }
    }

}
