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
public class Transaction {
    private LineItem[] lineItems;
    private final String custId;
    private final OutputStrategy output;

    public Transaction(String custId, OutputStrategy output) {
        this.custId = custId;
        lineItems = new LineItem[0];
        this.output = output;
    }
    
    public void addItem(String prodId, int qty, DataAccessStrategy db){
        LineItem temp = new LineItem(prodId, qty, db);
        this.addLineItem(temp);
    }
    
    private final void addLineItem(LineItem newItem){
        LineItem[] temp = new LineItem[lineItems.length+1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = newItem;
        lineItems = temp;
    }
    
    public void output(){
        output.writeCustomer(custId);
        for(LineItem l : lineItems){
        output.writeLine(l.writeItem());
        //attempting to add functionality to Transaction
        //double discount;
        //discount = lineItems[l].getDiscount();
        //output.updateTotals(lineItems[l].getCost());
        }
        output.writeTotals();
    }
}
