package observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest2 {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserver());
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers();
    }


    public interface Observer {
        void update();
    }

    public interface Subject {
        void registerObserver(Observer observer);
        void unregisterObserver(Observer observer);
        void notifyObservers();
    }

    public static class ConcreteSubject implements Subject {
        private List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void unregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }

    public static class ConcreteObserver implements Observer {
        @Override
        public void update() {
            // 执行相应的操作
            System.out.println("ConcreteObserver is notified.");
        }
    }

    //观察者1
    public static class ConcreteObserverOne implements Observer {
        @Override
        public void update() {
            //TODO: 获取消息通知，执行自己的逻辑...
            System.out.println("ConcreteObserverOne is notified.");
        }
    }

    //观察者2
    public static class ConcreteObserverTwo implements Observer {
        @Override
        public void update() {
            //TODO: 获取消息通知，执行自己的逻辑...
            System.out.println("ConcreteObserverTwo is notified.");
        }
    }
}
