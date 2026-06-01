package cn.ljq.springboot.visitorPattern19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 访问者模式
 * 优点：将对象结构和对对象的操作分离开来
 * 缺点：对象结构发生变化，所有访问者都需要修改，维护成本较高
 * <p>
 * 适用于对象结构很稳定，操作多的场合。比如系统中的项目介绍文档(甲方给的，基本不变)，但是对其的合理性检查、规范性检查等较多
 * <p>
 * eg：对象结构：大观园里的人物、房子、花草
 * 访问者：刘姥姥，怎么看待  大观园里的人物、房子、花草
 * 访问者：贾雨村，怎么看待  大观园里的人物、房子、花草
 */
public class VisitorTest {
    public static void main(String[] args) {

        //对象结构 *大观园
        ObjectStructure obj = new ObjectStructure();
        //元素  *大观园的房子
        obj.add(new ConcreteElementA("房子"));
        //元素  *大观园的花草
        obj.add(new ConcreteElementB("花草"));

        //创建A访问者 *刘姥姥
        Visitor visitor = new ConcreteVisitorA();
        //大观园里的人物、房子 接受 刘姥姥访问
        obj.accept(visitor);


        System.out.println("-------------------");
        //创建B访问者 *贾雨村
        Visitor visitor1 = new ConcreteVisitorB();
        //大观园里的人物、房子 接受 贾雨村访问
        obj.accept(visitor1);


    }
}

//抽象访问者
interface Visitor {
    void visit(ConcreteElementA elementA);

    void visit(ConcreteElementB elementB);

}

//具体访问者A 刘姥姥
class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者A：刘姥姥，访问大观园的：" + elementA.getName());
        elementA.doSomethingA("高大");
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("具体访问者A：刘姥姥，访问元素：" + elementB.getName());
        elementB.doSomethingB("鲜艳");
    }
}

//具体访问者B
class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者B：贾雨村，访问元素：" + elementA.getName());
        elementA.doSomethingA("是官员府邸");
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("具体访问者B：贾雨村，访问元素：" + elementB.getName());
        elementB.doSomethingB("点缀之笔");
    }
}

//抽象元素
interface Element {
    void accept(Visitor visitor);
}

//具体元素A 房子
class ConcreteElementA implements Element {
    String name;
    public ConcreteElementA(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void doSomethingA(String str) {
        System.out.println("ConcreteElementA(房子)--------"+str+"-------");
    }
}

class ConcreteElementB implements Element {
    String name;
    public ConcreteElementB(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void doSomethingB(String str) {
        System.out.println("ConcreteElementB(花草)------"+str+"---------");
    }
}

//对象结构 *大观园
class ObjectStructure {
    private List<Element> elements = new ArrayList<Element>();

    public ObjectStructure() {
    }

    public void add(Element element) {
        this.elements.add(element);
    }

    public void remove(Element element) {
        this.elements.remove(element);
    }

    public void accept(Visitor visitor) {
        Iterator<Element> iterator = elements.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }
}