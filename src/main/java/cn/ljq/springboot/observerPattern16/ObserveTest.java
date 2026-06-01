package cn.ljq.springboot.observerPattern16;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public class ObserveTest {
    public static void main(String[] args) {
        Target t = new subTarget();
        Observer observer = new SubObserver("a");
        t.addObserver(observer);
        t.addObserver(new SubObserver("b"));
        t.addObserver(new SubObserver("c"));
        t.removeObserver(observer);
        t.notifyObserver();
    }
}

//目标
interface Target {
    List<Observer> observers = new ArrayList<Observer>();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

//具体目标
class subTarget implements Target {


    @Override
    public void addObserver(Observer observer) {
        System.out.println("创建观察者:"+observer);
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        System.out.println("删除观察者:"+observer);
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.stream().forEach(observer -> {
            observer.response();
        });
    }
}

//观察者
interface Observer {
    void response();
}

//具体观察者
class SubObserver implements Observer {
    String name;
    public SubObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void response() {
        System.out.println("通知观察者："+name);
    }
}