package org.example.strategy;


import java.math.BigDecimal;

public class FruitContext {

    private FruitStrategy fs = null;

    public FruitContext(FruitStrategy fs){
        this.fs = fs;
    }

    public BigDecimal qutoPrice(String price, String n){
        return fs.calcPrice(price, n);
    }

}
