package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDesign2 {

    public static void main(String[] args) {
        new ProxyDesign2().testProxy();
    }

    private void testProxy() {
        RealSubject realSubject = new RealSubject();
        ProxyHandler proxyHandler = new ProxyHandler(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(), proxyHandler);
        subject.request();
    }

    interface Subject{
        void request();
    }

    class RealSubject implements Subject{
        @Override
        public void request(){
            System.out.println("request");
        }
    }

    /**
     * 代理类的调用处理器
     */
    class ProxyHandler implements InvocationHandler {
        private final Subject subject;
        public ProxyHandler(Subject subject){
            this.subject = subject;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作
            System.out.println("====before====");
            Object result = method.invoke(subject, args);
            System.out.println("====after====");
            return result;
        }
    }

}
