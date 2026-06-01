package cn.ljq.springboot.adapterPattern06;

/**
 * 适配器模式
 * 原有适配者实现A，目标接口是要实现B
 * 需要适配器实现目标接口，并把适配者注入进来
 *
 *
 * 应用场景：用于接口的不兼容，及第三方软件的引入
 * eg：两孔插座需要适配三孔插座，需要安装的转换器
 */
public class AdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        ObjectAdapter objectAdapter = new ObjectAdapter(adaptee);
        objectAdapter.requestA();
    }
}

//目标接口
interface target {
    void requestA();
}

//适配者(原本的逻辑)
class Adaptee {
    public void requestB() {
        System.out.println("适配者本身的业务代码 --------requestB");
    }
}

class ObjectAdapter implements target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void requestA() {
        adaptee.requestB();
        System.out.println("我的需求是requestA，已有的逻辑是requestB,当前处于requestA方法中--------");
    }
}