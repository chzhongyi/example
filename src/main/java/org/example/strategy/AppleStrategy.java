package org.example.strategy;

import org.example.entity.AppleInfo;

import java.math.BigDecimal;

public class AppleStrategy implements FruitStrategy{


    @Override
    public BigDecimal calcPrice(String price, String n) {
        return new BigDecimal(price).multiply(new BigDecimal(n));
    }





}
