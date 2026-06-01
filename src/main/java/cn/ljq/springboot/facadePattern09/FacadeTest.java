package cn.ljq.springboot.facadePattern09;



/**
 * 外观模式
 * 应用场景：简化流程，丝滑完成一系列操作
 *
 * 优点：减少耦合，子系统之间没有相互调用，简化代码
 * 缺点：扩展需要修改原外观类
 *
 * 举例：往冰箱放东西步骤：1.打开冰箱门 2.放入东西 3.关闭冰箱门
 * */
public class FacadeTest {
    public static void main(String[] args) {
        System.out.println("往冰箱放东西步骤:");
        Facade facade = new Facade();
        facade.doSomething();
    }
}
//外观类
class  Facade{
    SubSystem01 subSystem01 = new SubSystem01();
    SubSystem02 subSystem02 = new SubSystem02();
    SubSystem03 subSystem03 = new SubSystem03();
    void doSomething(){
        subSystem01.openDoor();;
        subSystem02.setSomething();
        subSystem03.closeDoor();
    }
}
//子系统1
class SubSystem01{
    void openDoor(){
        System.out.println("1.打开冰箱门--------");
    }

}
//子系统2
class SubSystem02{
    void setSomething(){
        System.out.println("2.放入东西----------");
    }

}
//子系统3
class SubSystem03{
    void closeDoor(){
        System.out.println("3.关闭冰箱门----------");
    }
}