package cn.ljq.springboot.prototypePattern05;



/***
 * 原型模式
 *  1.就是类实现了Cloneable接口，重写clone()方法，可以加自己的逻辑
 *  2.创建对象时创建一次即可
 *
 *  优点：创建一次对象，节约了内存成本
 *  缺点：不容易拓展，每个类都得实现clonable接口
 *
 *  eg：类似安装操作系统需要很久时间，但安装好后直接复制给别人，就可以很快使用
 * */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype();
        Prototype p2 = (Prototype)p1.clone();
        System.out.println("p1和p2是否相等----------"+(p1==p2));
    }
}

class Prototype implements Cloneable{

    public Prototype(){
        System.out.println("原型模型----本体");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
