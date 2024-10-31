/*
package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDesign4 {

    public static void main(String[] args) {
        new ProxyDesign4().test();
    }

    private void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyClass.class); // 设置原始类
        enhancer.setCallback(new MyMethodInterceptor()); // 设置代理处理器
        MyClass proxyObject = (MyClass) enhancer.create(); // 创建代理对象
        proxyObject.doSomething(); // 调用代理对象的方法
    }

    public class MyClass {
        public void doSomething() {
            System.out.println("Original method");
        }
    }

    public class MyMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            // 在方法调用前执行额外的逻辑
            System.out.println("Before method invocation");
            // 调用原始对象的方法
            Object result = proxy.invokeSuper(obj, args);
            // 在方法调用后执行额外的逻辑
            System.out.println("After method invocation");
            return result;
        }
    }
}
*/
