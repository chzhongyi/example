package org.example.test;

import org.example.decorator.Cash;
import org.example.decorator.CashDecorator;
import org.example.decorator.FullReduceDecorator;
import org.example.decorator.NormalCash;
import org.example.entity.FullReduceRule;
import org.example.entity.StrawberryInfo;
import org.example.strategy.*;

import java.math.BigDecimal;

public class Test {

    public static void main( String[] args ){

        StrawberryInfo strawberryInfo = new StrawberryInfo();
        FruitStrategy apple = new AppleStrategy();
        FruitStrategy strawberry = new StrawberryStrategy(strawberryInfo);
        FruitContext appcontext = new FruitContext(apple);
        FruitContext strawberrycontext = new FruitContext(strawberry);
        BigDecimal applePrice = appcontext.qutoPrice("8","2");
        BigDecimal strawberryPrice = strawberrycontext.qutoPrice("13","2");
        BigDecimal totalPrice1 = applePrice.add(strawberryPrice);
        Cash cash1 = new CashDecorator(new NormalCash(totalPrice1));
        String totalCash1 = cash1.totalPrice();
        System.out.println(totalCash1);
        //增加的芒果
        FruitStrategy mango = new MangoStrategy();
        FruitContext mangocontext = new FruitContext(mango);
        BigDecimal mangoPrice = mangocontext.qutoPrice("20","6");
        BigDecimal totalPrice2 = mangoPrice.add(totalPrice1);
        Cash cash2 = new CashDecorator(new NormalCash(totalPrice2));
        String totalCash2 = cash2.totalPrice();
        System.out.println(totalCash2);
        //草莓限时打八折
        strawberryInfo.setBroken(true);
        strawberryInfo.setBrokenRate(new BigDecimal("0.8"));
        BigDecimal strawberryPriceBroken = strawberrycontext.qutoPrice("13","2");
        BigDecimal totalPrice3 = applePrice.add(strawberryPriceBroken).add(mangoPrice);
        Cash cash3 = new CashDecorator(new NormalCash(totalPrice3));
        String totalCash3 = cash3.totalPrice();
        System.out.println(totalCash3);

        //满减
        Cash cash4 = new FullReduceDecorator(new NormalCash(totalPrice2),new FullReduceRule());
        String totalCash4 = cash4.totalPrice();
        System.out.println(totalCash4);



    }
}
