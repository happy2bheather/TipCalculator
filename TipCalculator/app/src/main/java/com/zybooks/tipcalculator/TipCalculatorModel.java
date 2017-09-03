package com.zybooks.tipcalculator;

/**
 * Created by Heather on 9/2/2017.
 */

public class TipCalculatorModel {

    Float bill;
    Float percentage;
    Float tip;
    Float total;

    public Float getBill() {
        return bill;
    }
    public void setBill(Float bill) {
        this.bill = bill;
    }

    public Float getPercentage() {
        return percentage;
    }
    public void setPercentage(Float percentage) {
        this.percentage = percentage / 100;
    }

    public Float getTip() {
        this.tip= bill * percentage;
        return tip;
    }
    public void setTip(Float tip) {
        this.tip = tip;
    }

    public Float getTotal() {
        this.total= tip + bill;
        return total;
    }
    public void setTotal(Float total) {
        this.total = total;
    }
}
