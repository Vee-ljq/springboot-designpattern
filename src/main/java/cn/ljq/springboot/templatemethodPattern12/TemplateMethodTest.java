package cn.ljq.springboot.templatemethodPattern12;


/**
 *  模版方法
 *  封装不变的，拓展可变的，公共方法在父类中实现，需要拓展的由子类继承重写实现
 *  缺点：子类的结果会影响父类，修改父类的公共方法等，全部子类都需要改一遍，较为复杂
 * */
public class TemplateMethodTest
{
    public static void main(String[] args) {

        System.out.println("-------林黛玉------");
        TemplateMethod t1 = new ConcreteObj01("林黛玉");
        t1.publicMethod();

        System.out.println("-------贾宝玉------");
        TemplateMethod t2 = new ConcreteObj02("贾宝玉");
        t2.publicMethod();

    }
}

//抽象的模版方法，包含公共方法和拓展方法
abstract class TemplateMethod{
    public void publicMethod(){
        getBed();
        eatFood();
        haveRelax();
        doSomething();
    };
    abstract void doSomething();
    void getBed(){
        System.out.println("每天必须从温暖的被窝爬起");
    }
    void eatFood(){
        System.out.println("每天必须吃饭");
    }
    void haveRelax(){
        System.out.println("每天必须睡觉");
    }
}
class ConcreteObj01 extends TemplateMethod{
    String name;

    public ConcreteObj01(String name) {
        this.name = name;
    }

    @Override
    void doSomething() {
        System.out.println(name+":工作内容是敲代码，键盘冒烟的那种！");
        doSport();
    }
    void doSport() {
        System.out.println(name+":今天去爬山看星星了");

    }
}
class ConcreteObj02 extends TemplateMethod{
    String name;
    public ConcreteObj02(String name) {
        this.name = name;

    }

    @Override
    void doSomething() {
        System.out.println(name+":工作内容是陪伴老人聊天度过无聊的下午！");
        doSport();

    }

    void doSport() {
        System.out.println(name+":今天做的运动是：俯卧撑100个");

    }
}