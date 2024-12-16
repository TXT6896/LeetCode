package tao.designMode.proxy;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        //目标对象
        Persion  target = new Student();
        //代理对象
        ProxyHandler proxyHandler = new ProxyHandler(target);
        //创建代理dp类对象
        //JDK会通过传入的参数信息动态地在内存中创建和.class文件等同的字节码
        //然后会根据相应的字节码转换成对应的class
        //最后创建代理类实例
        Persion proxy = (Persion) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyHandler);

        proxy.talk();
        System.out.println("------------------------");
        proxy.sing();
    }
}
