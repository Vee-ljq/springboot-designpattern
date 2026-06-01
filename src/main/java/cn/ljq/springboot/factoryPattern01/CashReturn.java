package cn.ljq.springboot.factoryPattern01;

/**
 * 满300减100
 * */
public class CashReturn extends CashSuper {

    private  double a = 0.0d;

    private  double b = 0.0d;

    public CashReturn(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public  double acceptMoney(double money) {
        double result = money;
        if (result>=a) {
            result = result-Math.floor(money/a)*b;
        }
        return result;
    }
}
