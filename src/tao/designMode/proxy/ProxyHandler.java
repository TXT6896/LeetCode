package tao.designMode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private final Object target;

    public ProxyHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置操作。。");
        Object invoke = method.invoke(target, args);
        System.out.println("后置操作。。");
        return invoke;
    }
}
