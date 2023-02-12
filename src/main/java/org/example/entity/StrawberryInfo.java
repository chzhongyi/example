package org.example.entity;

import java.math.BigDecimal;

public class StrawberryInfo {


    private boolean broken = false;


    private BigDecimal brokenRate = new BigDecimal(1);



    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }
    public BigDecimal getBrokenRate() {
        return brokenRate;
    }

    public void setBrokenRate(BigDecimal brokenRate) {
        this.brokenRate = brokenRate;
    }

}
