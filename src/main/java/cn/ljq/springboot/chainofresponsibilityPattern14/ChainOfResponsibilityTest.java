package cn.ljq.springboot.chainofresponsibilityPattern14;



/**
 * 责任链模式
 * 请求沿着责任链至每个节点，判断是不是本节点应该处理的节点
 *  优点：将每个节点串联成链式，降低耦合
 *  缺点：不能确保请求一定被执行，因为责任链的制定者是客户端，设置错误什么的都无法完成
 *
 *eg：审批流程，请假审批流程：组长-部门经理-总经理。
 * */
public class ChainOfResponsibilityTest {

    public static void main(String[] args) {
        Handler handler = new FirstHandler();
        Handler handler2 = new SecondHandler();
        handler.setNext(handler2);
        handler.handleRequest("two");
    }
}

//父类
abstract class Handler{
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }
    public Handler getNext() {
        return next;
    }
    public abstract void handleRequest(String request);
}
//第一个节点
class FirstHandler extends Handler{

    @Override
    public void handleRequest(String request) {
        if (request.equals("one")) {
            System.out.println("这是第一个节点，处理请求");
        }else{
           getNext().handleRequest(request);
        }
    }
}
//第二个节点
class SecondHandler extends Handler{
    @Override
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("这是第二个节点，处理请求");
        }else{
            getNext().handleRequest(request);
        }
    }
}