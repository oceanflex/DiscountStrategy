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
    private Customer customer;
    private Transaction transaction;

    public Register(Customer customer, Transaction transaction) {
        this.customer = customer;
        this.transaction = transaction;
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
