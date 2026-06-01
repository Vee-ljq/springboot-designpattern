package cn.ljq.springboot.singletonPattern03;

public class LazySingeleton {
    private static  volatile  LazySingeleton instance = null;

    private LazySingeleton() {
    }
    public static synchronized LazySingeleton getInstance() {
        System.out.println("饿汉模式：getInstance()------第一步是否为null----"+instance);
        if (instance == null) {
            instance = new LazySingeleton();
        }
        System.out.println("饿汉模式：getInstance()------返回的对象是否为null----"+instance);
        return instance;
    }
}
