package cn.ljq.springboot.singletonPattern03;

public class HungrySingleton {

    private final static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        System.out.println("懒汉模式：getInstance()------返回的对象是否为null----"+instance);
        return instance;
    }
}
