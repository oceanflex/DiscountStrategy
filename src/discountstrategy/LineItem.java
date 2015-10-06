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
public class LineItem {
    private static final double MIN_QTY = 0;
    private Product product;
    private double qty;
    private final DataAccessStrategy db;

    public LineItem(String prodId, double qty, DataAccessStrategy db) {
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
    
    private void findProduct (String prodId){
        this.product = db.findProduct(prodId);
    }
    
    public String[] writeItem(){
        String id = product.getProdId();
        String name = product.getName();
        String Quantity = "$"+ this.qty;
        String cost = "$"+(product.getUnitPrice() * this.qty);
        String discount ="$"+ product.getDiscountAmt(this.qty);
        String[] back = {id, name, cost, Quantity, discount};
        return back;
    }
    
}
