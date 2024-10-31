package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于接口动态代理
 */
public class ProxyDesign3 {

    public static void main(String[] args) {
        new ProxyDesign3().test();
    }

    private void test() {
        MyInterface originalObject = new MyOriginalObject(); // 创建原始对象
        MyInvocationHandler invocationHandler = new MyInvocationHandler(originalObject); // 创建代理处理器
        MyInterface proxyObject = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                invocationHandler); // 创建代理对象
        proxyObject.doSomething();
    }

    //1、定义接口类
    public interface MyInterface {
        void doSomething();
    }

    public class MyOriginalObject implements MyInterface {
        @Override
        public void doSomething() {
            System.out.println("原始对象方法执行");
        }
    }

    public class MyInvocationHandler implements InvocationHandler {
        private Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 在方法调用前执行额外的逻辑
            System.out.println("Before method invocation");
            // 调用目标对象的方法
            Object result = method.invoke(target, args);
            // 在方法调用后执行额外的逻辑
            System.out.println("After method invocation");
            return result;
        }
    }
}
