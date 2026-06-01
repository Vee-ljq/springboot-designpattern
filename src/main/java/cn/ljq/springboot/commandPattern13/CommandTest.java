package cn.ljq.springboot.commandPattern13;

/**
 * 命令模式
 * 优点：1.接收方和调用方，通过传对象给接收方和调用方，两边互不认识达到解耦的目的；
 *      2.新增具体命令满足开闭原则，不影响其他类
 *      3.将命令由动词变成名词，可以达到撤销和重做
 * 缺点：形式较为复杂，抽离代码稍难理解
 *
 *
 * 比如看电视，遥控器--调用者，遥控器上的按键--命令，电视--接收者
 * */
public class CommandTest {
    public static void main(String[] args) {
        ConcreteCommand command = new ConcreteCommand();
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.doSomething();
    }
}
//调用者  *看电视的人
class Invoker{
    private Command command;


    public void setCommand(Command command01) {
        this.command = command01;
    }

    public void doSomething(){
        command.execute();
   }
}
//父命令 *遥控器的按键
interface Command{
    void execute();
}
//命令
 class ConcreteCommand implements Command{
    private Receiver receiver;

    public ConcreteCommand() {
        this.receiver = new Receiver();
    }

    public void execute(){
        System.out.println("通知接收者："+receiver);
        receiver.action();
   };
}

//接收者 *电视的接收器
class Receiver{
public Receiver() {
}
public void action(){
    System.out.println("接收者执行操作！");
}
}