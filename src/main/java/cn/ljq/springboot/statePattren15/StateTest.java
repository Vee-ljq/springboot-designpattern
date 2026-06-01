package cn.ljq.springboot.statePattren15;
/**
 * 状态模式
 * 将每个状态变成对象，内部可以自己管理，任意切换
 *
 * eg：人的情绪有快乐、悲伤，现在情绪就是一个context，快乐是一个对象，悲伤是一个对象，快乐对象内部可以转换成悲伤对象
 *
 * */
public class StateTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.hander();
        context.hander();
        context.hander();
        context.hander();

    }
}


//上下文
class Context{
    private State state;

    public Context() {
        this.state = new ConcreteState1();
    }
    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }

    void hander(){
        state.hander(this);
    }

}
//抽象状态类
abstract class State{
  abstract void hander(Context context);
}
//具体状态类
class ConcreteState1 extends State{

    @Override
    void hander(Context context) {
        System.out.println("A状态类---");
        context.setState(new ConcreteState2());
    }
}
//具体状态类
class ConcreteState2 extends State{

    @Override
    void hander(Context context) {
        System.out.println("B状态类---");
        context.setState(new ConcreteState1());
    }
}