package org.example.strategy;

import java.math.BigDecimal;

public interface FruitStrategy {

    BigDecimal calcPrice(String price, String n);

}
