package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者设计模式
 */
public class ObserverTest {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        //1.创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        //2.订阅公众号
        subject.attach(new WeiXinObserver("打工充"));
        subject.attach(new WeiXinObserver("心怡宝"));
        subject.attach(new WeiXinObserver("逗比果"));

        //3.公众号更新
        subject.notify("打工充 设计模式专栏更新了！");
    }

    //抽象的观察者
    public interface Observer {
        void update(String message);
    }

    //具体的观察者角色类
    public static class WeiXinObserver implements Observer{
        private String name;

        public WeiXinObserver(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + ": " + message);
        }
    }

    //观察对象
    public interface Subject {

        //添加订阅者(观察者对象)
        void attach(Observer observer);

        //删除订阅者
        void detach(Observer observer);

        //通知订阅者更新消息
        void notify(String message);
    }

    //具体主题角色类
    public static class SubscriptionSubject implements Subject{

        //定义一个集合，用来存储多个观察者对象
        private List<Observer> weiXinUserList = new ArrayList<>();

        @Override
        public void attach(Observer observer) {
            weiXinUserList.add(observer);
        }

        @Override
        public void detach(Observer observer) {
            weiXinUserList.remove(observer);
        }

        @Override
        public void notify(String message) {
            //遍历集合
            for (Observer observer : weiXinUserList) {
                //调用观察者对象中的 update 方法
                observer.update(message);
            }
        }
    }

}
