package cn.ljq.springboot.factoryPattern01;

/**
 * 打8折
 *
 * */
public class CashRebate extends CashSuper{
    private double a = 0.0d;

    public CashRebate(double a) {
        this.a = a;
    }

    @Override
    public double acceptMoney(double money) {
        return money*a;
    }
}
