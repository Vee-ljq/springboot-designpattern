package cn.ljq.springboot.factoryPattern01;
/**
 *
 * 工厂类模式
 * 1.知道类型，由工厂创建对应的对象
 *
 * 优点：创建对象交给工厂执行，统一了代码入口
 * 缺点：违反了开闭原则，拓展需要修改原来的代码
 *
 *
 * */
public class CashFactory {
    public static CashSuper getCashSuper(String cashType){
       return switch (cashType){
            case "正常付费"-> new CashNormal();
            case "打8折"-> new CashRebate(0.8);
            case "满300减100"-> new CashReturn(300,100);
            default-> throw new IllegalStateException("Unexpected value: " + cashType);
       };
    }
}
