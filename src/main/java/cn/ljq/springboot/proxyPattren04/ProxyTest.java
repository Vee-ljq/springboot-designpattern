package cn.ljq.springboot.proxyPattren04;

/**
 * 代理模式
 * 1.代理类中有真实类，相同的功能，可以进行拓展
 *
 * 优点：对访问客户来说，保护了真实对象的信息，其只能调用代理对象，真实对象不可见
 * 缺点:代码冗余，一次调用可以做到的事情加了一层，加大了内存成本
 *
 * 举例：代理类似中介，比如买火车票，无需去火车站，12306就可操作。再入明星身边的经纪人，代理一切事务。
 *
 *
 * */



public class ProxyTest {
    public static void main(String[] args) {
        ProxySubject proxySubject = new ProxySubject();
        proxySubject.doSomething();
    }
}
//抽象主题类
interface Subject{
    void doSomething();
}
//真实主题类
class  RealSubject implements Subject{
    public void doSomething() {
        System.out.println("真实主题做的事情----real");
    }
}
//代理主题类
class  ProxySubject implements Subject{
    private RealSubject realSubject;

    @Override
    public void doSomething() {
        postProxy();
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.doSomething();
        afterProxy();
    }
    private void postProxy() {
        System.out.println("代理主题----post");
    }
    private void afterProxy() {
        System.out.println("代理主题----after");
    }
}