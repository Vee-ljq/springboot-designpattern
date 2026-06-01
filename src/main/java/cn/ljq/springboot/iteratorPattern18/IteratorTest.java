package cn.ljq.springboot.iteratorPattern18;

import java.util.ArrayList;

import java.util.List;

/**
 * 迭代器模式
 **/
public class IteratorTest {
    public static void main(String[] args) {
        Aggregate a = new ConcreteAggregate();
        a.add("贾元春");
        a.add("贾迎春");
        a.add("贾探春");
        a.add("贾惜春");
        System.out.println("聚合的内容有：");
        IteratorA it = a.getIteratorA();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}

//聚合接口
interface Aggregate {
    void add(Object o);

    void remove(Object o);

    IteratorA getIteratorA();
}

//具体聚合
class ConcreteAggregate implements Aggregate {

    List<Object> list = new ArrayList<Object>();

    @Override
    public void add(Object o) {
        list.add(o);
    }

    @Override
    public void remove(Object o) {
        list.remove(o);
    }

    @Override
    public IteratorA getIteratorA() {
        return new ConcreteIteratorA(list);
    }
}

//迭代器接口
interface IteratorA {
    Object first();

    Object next();

    boolean hasNext();

}

//具体迭代器
class ConcreteIteratorA extends ConcreteAggregate implements IteratorA {

    private int index = -1;

    public ConcreteIteratorA(List<Object> list) {
        super.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        return list.get(index);
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }
}