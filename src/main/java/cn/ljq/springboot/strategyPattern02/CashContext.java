package cn.ljq.springboot.strategyPattern02;

import cn.ljq.springboot.factoryPattern01.CashNormal;
import cn.ljq.springboot.factoryPattern01.CashRebate;
import cn.ljq.springboot.factoryPattern01.CashReturn;
import cn.ljq.springboot.factoryPattern01.CashSuper;

import java.util.HashMap;

/**
 * 策略模式
 * 1.将方法编程每一条策略，对应每一个行为
 *
 * 优点：对客户来说，无需关心对象创建，仅明确类型和关键信息即可，拓展容易，加个接口(策略)即可
 *
 *
 * 举例：打折时有：正常收费、满减、折扣，这三类就叫三条策略
 *
 * */


public  class CashContext {




    private  static CashSuper cs;
    private static final HashMap hashMap = new HashMap();
    static {
        hashMap.put("正常付费", new CashNormal());
        hashMap.put("打8折", new CashRebate(0.8));
        hashMap.put("满300减100", new CashReturn(300,100));

    }

    public CashContext (String strategy) {
        cs = (CashSuper) hashMap.get(strategy);
        if (cs == null) {
            throw new IllegalStateException("Unexpected value: " + strategy);
        }
       /* this.cs= switch (strategy){
            case "正常付费"-> new CashNormal();
            case "打8折"-> new CashRebate(0.8);
            case "满300减100"-> new CashReturn(300,100);
            default-> throw new IllegalStateException("Unexpected value: " + strategy);
        };*/
    }


    public static  double getResult(double money){
        return  cs.acceptMoney(money);
    }

}
