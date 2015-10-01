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
    
    private void addLineItem(LineItem newItem){
        LineItem[] temp = new LineItem[lineItems.length+1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = newItem;
        lineItems = temp;
    }
}