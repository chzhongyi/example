package org.example.strategy;

import org.example.entity.StrawberryInfo;

import java.math.BigDecimal;

public class StrawberryStrategy implements FruitStrategy{

    private StrawberryInfo strawberryInfo;

    public StrawberryStrategy(StrawberryInfo strawberryInfo){
        this.strawberryInfo = strawberryInfo;
    }

    /**
     * 1、异常信息可以通过枚举类列举
     * 2、异常类型可以自定义配置
     * 3、水果相关的规则可以配置化，统一实现，策略模式不灵活
     * */
    @Override
    public BigDecimal calcPrice(String price, String n) {
        BigDecimal level = new BigDecimal(0);
        BigDecimal bd = new BigDecimal(price);

        if(bd.compareTo(level) <= 0 || new BigDecimal(n).compareTo(level) <= 0){
            throw new RuntimeException("传入数据有误");
        }
        if(!strawberryInfo.isBroken()){
            return bd.multiply(new BigDecimal(n));
        }
        return bd.multiply(new BigDecimal(n)).multiply(strawberryInfo.getBrokenRate());
    }
}
