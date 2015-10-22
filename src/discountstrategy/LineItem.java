/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.io.FileNotFoundException;
import java.text.NumberFormat;

/**
 *
 * @author zsummers
 */
public class LineItem {
    private static final double MIN_QTY = 0;
    private Product product;
    private double qty;
    private final DataAccessStrategy db;

    public LineItem(String prodId, double qty, DataAccessStrategy db)throws FileNotFoundException {
         this.db = db;
         findProduct(prodId);
        setQty(qty);
       
    }

    public final void setQty(double qty) {
        if(qty >= MIN_QTY){
            this.qty = qty;
        }else{
            this.qty = MIN_QTY;
        }
    }
    
    private void findProduct (String prodId)throws FileNotFoundException{
        this.product = db.findProduct(prodId);
    }
    
    public double getDiscount(){
        return product.getDiscountAmt(this.qty);
    }
    
    public double getCost(){
        return (product.getUnitPrice() * this.qty);
    }
    
    public String[] writeItem()throws NullPointerException{
        NumberFormat money = NumberFormat.getCurrencyInstance();
        String id = product.getProdId();
        String name = product.getName();
        String quantity;
        if (this.qty == (int)this.qty){
        quantity = "" + (int)this.qty;
        }else{
            quantity = "" + this.qty;
        }
        String cost = money.format(this.getCost());
        String discount =money.format(this.getDiscount());
        String[] back = {id, name, cost, quantity, discount};
        return back;
    }
    
}
