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
public interface DiscountStrategy {

    double getDiscountAmt(double unitPrice, double qty);

    double getDiscountRate();

    void setDiscountRate(double discountRate);
    
}
