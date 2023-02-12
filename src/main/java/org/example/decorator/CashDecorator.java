package org.example.decorator;

public class CashDecorator implements Cash {

    private Cash cash;

    public CashDecorator(Cash cash){
        this.cash = cash;
    }

    @Override
    public String totalPrice() {
        return cash.totalPrice();
    }
}
