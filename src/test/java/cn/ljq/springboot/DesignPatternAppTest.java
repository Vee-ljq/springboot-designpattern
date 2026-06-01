package cn.ljq.springboot;

import cn.ljq.springboot.factoryPattern01.CashFactory;
import cn.ljq.springboot.factoryPattern01.CashSuper;
import cn.ljq.springboot.prototypePattern05.PrototypeTest;
import cn.ljq.springboot.proxyPattren04.ProxyTest;
import cn.ljq.springboot.singletonPattern03.HungrySingleton;
import cn.ljq.springboot.singletonPattern03.LazySingeleton;
import cn.ljq.springboot.strategyPattern02.CashContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class DesignPatternAppTest
{
    @Test
    public void contextLoads() throws CloneNotSupportedException {

        //1.简单工厂模式
       /* CashSuper cashSuper01 = CashFactory.getCashSuper("正常付费");
        System.out.println("正常付费--------------------"+cashSuper01.acceptMoney(800));
        CashSuper cashSuper02 = CashFactory.getCashSuper("打8折");
        System.out.println("打8折--------------"+cashSuper02.acceptMoney(800));
        CashSuper cashSuper03 = CashFactory.getCashSuper("满300减100");
        System.out.println("满300减100--------------"+cashSuper03.acceptMoney(800));*/


        //2.策略模式
       /* double finalMoney01 = new CashContext("正常付费").getResult(800);
        System.out.println("策略模式--正常付费--"+finalMoney01);
        double finalMoney02 = new CashContext("打8折").getResult(800);
        System.out.println("策略模式--打8折--"+finalMoney02);
        double finalMoney03 = new CashContext("满300减100").getResult(800);
        System.out.println("策略模式--满300减100--"+finalMoney03);*/

        //3.单例模式
        /*LazySingeleton.getInstance();
        HungrySingleton.getInstance();*/

        //4.代理模式
        //new ProxyTest().main(new String[0]);

        //5.原型模式
        //new PrototypeTest().main(new String[0]);



    }
}
