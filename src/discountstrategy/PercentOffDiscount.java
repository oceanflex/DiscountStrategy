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
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate;
    //private int qty;

    public PercentOffDiscount(double discountRate) {
        this.setDiscountRate(discountRate);
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public double getDiscountAmt(double unitPrice, double qty){
        
        return unitPrice * qty * discountRate;
    }
}
