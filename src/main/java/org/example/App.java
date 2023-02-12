package org.example;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BigDecimal bd1 = new BigDecimal("320.8");
        BigDecimal bd2 = new BigDecimal(100);
        System.out.println(bd1.divide(bd2).intValue());
        System.out.println( "Hello World!" );
    }
}
