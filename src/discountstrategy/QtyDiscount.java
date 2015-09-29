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
public class QtyDiscount implements DiscountStrategy{
    private double discountRate;
    private double minQty;

    public QtyDiscount(double discountRate, double minQty) {
        this.setDiscountRate(discountRate);
        this.minQty = minQty;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public double getDiscountAmt(double unitPrice, double qty){
        if(qty>=minQty){
                    return unitPrice * qty * discountRate;
        }else{
            return 0;
        }
    }
}
