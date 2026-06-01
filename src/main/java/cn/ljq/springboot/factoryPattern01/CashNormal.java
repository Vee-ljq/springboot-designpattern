package cn.ljq.springboot.factoryPattern01;

/**
 * 正常付费
 * */
public class CashNormal extends CashSuper{
    @Override
    public double acceptMoney(double money) {
        return money;
    }
}
