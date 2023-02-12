package org.example.decorator;

import org.example.entity.FullReduceRule;

import java.math.BigDecimal;

public class FullReduceDecorator extends CashDecorator{

    private FullReduceRule fullReduceRule;


    public FullReduceDecorator(Cash cash, FullReduceRule fullReduceRule){
        super(cash);
        this.fullReduceRule = fullReduceRule;
    }

    @Override
    public String totalPrice() {
        BigDecimal bd = new BigDecimal(super.totalPrice());
        return bd.subtract(new BigDecimal(calcuRule(super.totalPrice()))).toPlainString();
    }

    /**
     * 1、总价相关的规则 根据Rule配置化，目前是写死
     * */
    public int calcuRule(String totalPrice){

         return new BigDecimal(totalPrice).divide(new BigDecimal(100)).intValue()*10;
    }
}
