package org.example.strategy;

import java.math.BigDecimal;

public class MangoStrategy implements FruitStrategy{
    @Override
    public BigDecimal calcPrice(String price, String n) {
        BigDecimal bd = new BigDecimal(price);
        return bd.multiply(new BigDecimal(n));
    }
}
