package cn.ljq.springboot.decoratorPattern07;
/**
 * 装饰器模型
 * 需要  抽象组件、具体组件、装饰器抽象组件、装饰器具体组件
 * 本身煎饼是一个容器A，自带鸡蛋，
 *
 * 举例：买一个煎饼果子自带鸡蛋，现在要加火腿，共同组成煎饼，鸡蛋和火腿就是煎饼的装饰部分
 *
 *
 * */
public class DecoratorTest {
    public static void main(String[] args) {
        Component c = new ConcreteComponent();
        System.out.println("***********************");
        Decorator cd = new ConcreteDecorator(c);
        cd.show();
}}


//抽象组件 *煎饼
interface Component{
    //*自带鸡蛋
    void show();
}

//具体组件 *鸡蛋
class ConcreteComponent implements Component{
    public ConcreteComponent() {
        System.out.println("具体组件--实例化------------");
    }
    @Override
    public void show() {
        System.out.println("具体组件--show()方法--------");
    }
}
//装饰抽象组件
class Decorator implements Component{
    private Component component;
    public Decorator(Component component) {
        this.component = component;
    }
    @Override
    public void show() {
        component.show();
    }
}

//具体抽象组件 *火腿
class ConcreteDecorator  extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }
    @Override
    public void show() {
        //*鸡蛋
        super.show();
        //*火腿
        insertShow();
    }
    private void insertShow() {
        System.out.println("装饰抽象组件---业务扩展--insertShow()方法------");
    }
}
