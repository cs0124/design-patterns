package proxy.DynamicProxy;

import proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeiPo implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target){
        this.target = target;

        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("找到了，如果合适那就办事吧");
    }

    private void before() {
        System.out.println("我是媒婆，开始物色合适的");
    }
}
