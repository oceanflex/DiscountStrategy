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
    private Product product;
    private double qty;
    private DataAccessStrategy db;

    public LineItem(String prodId, double qty, DataAccessStrategy db) {
        findProduct(prodId);
        this.qty = qty;
        this.db = db;
    }
    
    private void findProduct (String prodId){
        this.product = db.findProduct(prodId);
    }
    
}
