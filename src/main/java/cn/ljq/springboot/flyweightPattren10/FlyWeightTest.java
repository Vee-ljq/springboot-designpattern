package cn.ljq.springboot.flyweightPattren10;

import java.util.HashMap;

/**
 * 享元模式
 * 目的：避免创建重复的对象，节约内存空间；明确内部和外部
 * 内容：抽象享元、具体享元、享元工厂、客户端
 *  抽象享元用来接收非共享的角色
 *  具体享元就是具体角色
 *  享元工厂创建享元
 *
 *  eg：游戏开发时，背景中的水池元素在游戏的画面中经常出现，每次都创建水池对象，大量的重复对象被创建致使服务器性能变低
 *     分析：分清内部外部元素。
 *          内部：水池大小，颜色，形状
 *          外部：水池的位置坐标
 *
 *
 * **/
public class FlyWeightTest {
    public static void main(String[] args) {

        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        FlyWeight a = flyWeightFactory.getFlyWeight("水池");
        System.out.println("一获对象：水池-----"+a);
        FlyWeight a1 = flyWeightFactory.getFlyWeight("水池");
        System.out.println("二获对象：水池----"+a1);
        FlyWeight d = flyWeightFactory.getFlyWeight("树木");
        System.out.println("一获对象：树木----"+d);
        FlyWeight e = flyWeightFactory.getFlyWeight("石头");
        System.out.println("一获对象：石头----"+e);


        a.doSomething(new UnshareConcreteFlyWeight("位置：左上"));
        a.doSomething(new UnshareConcreteFlyWeight("位置：右下"));


    }
}

//非享元角色，即外部 *水池的坐标
class UnshareConcreteFlyWeight{
    String info;
    public UnshareConcreteFlyWeight(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
//抽象的享元角色
 interface FlyWeight{
    void doSomething(UnshareConcreteFlyWeight state);
}

//具体的享元实例 *水池
class ConcreteFlyWeight implements FlyWeight{
    String key;

    public ConcreteFlyWeight(String key) {
        this.key = key;
        System.out.println("具体享元对象---"+key+"-----被创建");
    }

    @Override
    public void doSomething(UnshareConcreteFlyWeight state) {

        System.out.println("具体享元："+key+"被调用！");
        System.out.println("非共享享元信息----"+state.getInfo());
    }
}

//享元工厂，*可以创建水池对象、树木对象、石头对象等等
class FlyWeightFactory{
    private HashMap<String,FlyWeight> weights = new HashMap();
    public FlyWeight getFlyWeight(String key){
        FlyWeight weight = (FlyWeight) weights.get(key);
        if(weight == null){
            System.out.println("对象："+key+" 不存在");
            weight = new ConcreteFlyWeight(key);
            weights.put(key, weight);
        }else{
            System.out.println("对象："+key+" 已存在，直接返回");
        }
        return weight;
    }

}