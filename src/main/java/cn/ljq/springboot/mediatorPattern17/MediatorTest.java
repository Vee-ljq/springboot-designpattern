package cn.ljq.springboot.mediatorPattern17;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式
 *
 * 复杂度转移到中介者的通知方法，来调停各同事类之间的行为
 * 优点：符合迪米特法则，每个同事对象间互不认识，低耦合
 * 缺点：同事多的话中介者负担较重，系统性能低
 *
 * eg：房子中介，中介需要把租客和房子的信息注册到中介所，有房源消息通知租客和房东
 *     房子中介所维护着所有租客和房东房子信息
 *
 * */

public class MediatorTest {
    public static void main(String[] args) {

        //租客
        Person lin= new ConcretePersonl("租客：林黛玉");
        //房东
        Person jia= new ConcretePersonJ("房东：贾宝玉");
        //中介
        AbstractMediator mediator = new ConcreteMediator();
        //租客信息注册到中介所
        mediator.register(lin);
        //房东信息注册到中介所
        mediator.register(jia);

        //租客可以询问中介房屋信息
        lin.setMediator(mediator);
        lin.send();

        //房东询问中介自己房子出租情况
        jia.setMediator(mediator);
        jia.send();

        //中介通知房东和租客
        mediator.call(lin,"有房出租");
        mediator.call(jia,"房已被租");



    }
}

//抽象中介
abstract class AbstractMediator {
   abstract void register(Person person);
   abstract void call(Person person,String msg);
}

//具体中介
class ConcreteMediator extends AbstractMediator{
    List<Person> persons = new ArrayList<Person>();

    @Override
    void register(Person person) {
    persons.add(person);
    }

    @Override
    void call(Person person,String msg) {
        for (Person p : persons) {
            if (person.equals(p)) {
                person.beCalled(person,msg);
            }
        }
        }

}
//抽象 租房的角色
abstract class Person{
   public AbstractMediator mediator;
   private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMediator(AbstractMediator mediator) {
        this.mediator = mediator;
    }
    abstract void beCalled(Person person,String msg);
    abstract void send();
}
//具体的租客 林黛玉
class ConcretePersonl extends Person{

    public ConcretePersonl(String name) {
        super(name);
    }

    @Override
    void beCalled(Person person,String msg) {
        System.out.println(person.getName()+"---beCalled---"+msg);
    }

    @Override
    void send() {
        System.out.println(getName()+"询问中介："+super.mediator);
    }
}
//具体的房东 贾宝玉
class ConcretePersonJ extends Person{

    public ConcretePersonJ(String name) {
        super(name);
    }

    @Override
    void beCalled(Person person,String msg) {
        System.out.println(person.getName()+"-------- beCalled"+msg);
    }

    @Override
    void send() {
        System.out.println(getName()+"询问中介："+super.mediator);
    }
}