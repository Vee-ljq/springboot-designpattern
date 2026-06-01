package cn.ljq.springboot.bridgePattren08;


/**
 * 桥接模式
 * 实现层，实现层具体实现类，抽象层、抽象层具体实现类
 * 完全区分了实现层及抽象层。实现层和抽象层各自拓展互不影响
 *
 *比如，描述图形，可以描述图形的形状m、颜色n，就有m✖️n种，过于复杂
 *
 * */
public class BridgeTest {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImpl();
        Abstraction abstraction = new RefinedAbstractImpl(implementor);
        abstraction.Operation();
    }
}

//实现层的角色  图形的形状，包括圆形、正方形等
interface  Implementor{
    void OpentionImpl();
}
//实现层的角色 具体实现
class ConcreteImpl implements Implementor{
    public void OpentionImpl() {
        System.out.println("具体实现ConcreteImpl----被访问");
    }
}
//抽象层的角色  图形的颜色
abstract class Abstraction{
    protected Implementor implementor;
    protected Abstraction(Implementor implementor) {
       this.implementor = implementor;
   }
    abstract void Operation();
}
//抽象层的角色 具体抽象实现
class RefinedAbstractImpl extends Abstraction{
    public RefinedAbstractImpl(Implementor implementor) {
        super(implementor);
    }
    public void Operation() {
        System.out.println(" --------------具体抽象实现类-------------");
        implementor.OpentionImpl();
        System.out.println(" --------------具体抽象实现类-------------");
    }
}