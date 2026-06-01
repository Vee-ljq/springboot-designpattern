package cn.ljq.springboot.compositePattern11;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * 树形节点，统一代码
 * 优点：客户端无感，仅调用一个方法即可。
 * 缺点：如果要区分节点的性质，需要判断类型
 *
 * eg：准备开战的指令传送：曹操(一人)->校尉(10人)->士兵(1000人，每个校尉管理100个士兵)，曹操一声令下，全军出击！
 *     曹操只需要知道校尉是哪10人，无需关心校尉下有多少士兵
 * */
public class CompositeTest {
    public static void main(String[] args) {
        Component leaf1 = new Leaf("士兵001");
        Component leaf2 = new Leaf("士兵002");
        Component leaf3 = new Leaf("士兵003");
        List<Component> leafs = new ArrayList<>();
        leafs.add(leaf1);
        leafs.add(leaf2);
        leafs.add(leaf3);
        Composite composite = new Composite(leafs);
        composite.info();

    }
}

//根节点 *曹操
interface Component{
    void info();
}
//树枝节点 *校尉
class Composite implements Component{
    private List<Component> leafs = new ArrayList();

    public Composite(List leafs) {
        this.leafs = leafs;
    }

    @Override
    public void info() {
        System.out.println("校尉已收到通知！开始下发！");
        leafs.stream().forEach(e-> {System.out.println("已通知："+e);e.info();});
    }
}
//叶子节点 *士兵
class Leaf implements Component{
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void info() {
        System.out.println(name+"已收到通知！");
    }
}