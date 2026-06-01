package cn.ljq.springboot.mementoPattren20;

/**
 * 备忘录模式
 * 有三个角色，发起者、备忘录、管理者
 * 优点：备忘录只对发起人透明，对管理者不透明，保证了很好的封装性
 * 缺点：备忘录和发起人此刻状态一致，如果存储多个状态会造成内存紧张
 *
 * eg：贾宝玉是发起者，通灵宝玉是备忘录，袭人是管理者。
 * 贾宝玉衔玉出生，通灵宝玉代表贾宝玉的初始正常状态，当状态变成迷糊，就立马佩戴由袭人保管的通灵宝玉，恢复正常状态
 *
 * */
public class MementoTest {
    public static void main(String[] args) {
        //发起人，带状态
        Originator originator = new Originator();
        originator.setState("运行正常");
        System.out.println("第一次状态：" + originator.getState());
        //创建发起人此刻的备忘录
        Memento memento = originator.createMemento();
        //交给管理者
        Caretaker caretaker = new Caretaker(memento);

        originator.setState("内存爆炸");
        System.out.println("第二次状态：" + originator.getState());
        //恢复上一个状态
        originator.restoreMemento(caretaker.getMemento());


    }
}

//发起人
class Originator{
    private String state;
    public Originator(){}
    public Originator(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    public Memento createMemento(){
            return new Memento(state);
    }
    public void restoreMemento(Memento memento){
        this.state = memento.getState();
        System.out.println("取出备忘录：恢复状态："+ state);
    }
}
//备忘录
class Memento{
    private String state;
    public Memento(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
}
//管理者
class Caretaker{
    Memento memento;
    public Caretaker(Memento memento){
        this.memento = memento;
    }
    public Memento getMemento(){
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}