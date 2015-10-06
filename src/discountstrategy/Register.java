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
    
    private void addItem(LineItem item){
        transaction.addLineItem(item);
    }
    
    public void addItems(LineItem[] items){
        for(LineItem l:items){
        this.addItem(l);
        }
    }
    
    public final void endTransaction(){
        transaction.output();
    }
    
}
