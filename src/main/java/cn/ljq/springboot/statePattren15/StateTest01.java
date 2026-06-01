package cn.ljq.springboot.statePattren15;

public class StateTest01 {
    public static void main(String[] args) {
        //状态是好、不好
        State01 state01 = new Context01();
        AContext context = new AContext(state01);
        context.handler();
        context.handler();
    }
}

//上下文容器
class AContext{
    private State01 state01;
    public AContext(State01 state01){
        this.state01 = state01;
    }
    public State01 getState01() {
        return state01;
    }
    public void setState01(State01 state01) {
        this.state01 = state01;
    }
    public void handler(){
        state01.swimming(this);
        state01.pashan(this);
    }
}
//状态接口
interface State01{
    //所有行为 比如游泳、爬山、
    void swimming(AContext context);
    void pashan(AContext context);

}
//状态：好
class Context01 implements State01{

    @Override
    public void swimming(AContext context) {
        System.out.println("游泳--状态：好");
    }

    @Override
    public void pashan(AContext context) {
        System.out.println("爬山--状态：好");
        context.setState01(new Context02());
    }


}
//状态：不好
class Context02 implements State01{

    @Override
    public void swimming(AContext context) {
        System.out.println("游泳--状态：不好");
    }

    @Override
    public void pashan(AContext context) {
        System.out.println("爬山--状态：不好");

    }
}
