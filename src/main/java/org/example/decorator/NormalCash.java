package org.example.decorator;

import java.math.BigDecimal;

public class NormalCash implements Cash{
    
    private BigDecimal totalPrice = null;
    
    public NormalCash(BigDecimal totalPrice){
        this.totalPrice = totalPrice; 
    }
    @Override
    public String totalPrice() {

        return totalPrice.toPlainString();
    }
}
