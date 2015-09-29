/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author zsummers
 */
public class NoDiscount implements DiscountStrategy{
    private double discountRate;
    //private int qty;

    public NoDiscount(double discountRate) {
        this.setDiscountRate(0);
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = 0;
    }
    
    public double getDiscountAmt(double unitPrice, double qty){
        
        return unitPrice * qty * discountRate;
    }
}
