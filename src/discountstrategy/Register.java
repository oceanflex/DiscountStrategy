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
public class Register {
    private String custId;
    private Transaction transaction;
    private DataAccessStrategy db;

    public Register(DataAccessStrategy db) {
        this.db = db;
    }

    public void setCustomer(String custId) {
        this.custId = custId;
    }

    public Register(DataAccessStrategy db, String custId, Transaction transaction) {
        this.db = db;
        this.custId = custId;
        this.transaction = transaction;
    }
    
    public final void newTransaction(OutputStrategy output){
        transaction = new Transaction(this.custId, output);
    }
    
    public final void newTransaction(String custId, OutputStrategy output){
        transaction = new Transaction(custId, output);
    }
    
    private void addItem(String prodId, int qty){
        transaction.addItem(prodId, qty, this.db);
    }
    
//    public void addItems(String[] prodIds){
//        for(String s:prodIds){
//        this.addItem(s);
//        }
//    }
    
    public final void endTransaction(){
        transaction.output();
    }
    
}
