/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void addItem(String prodId, int qty, DataAccessStrategy db) {
        LineItem temp = null;
        try {
            temp = new LineItem(prodId, qty, db);
        } catch (FileNotFoundException ex) {
            output.writeError(ex);
        }
        this.addLineItem(temp);
        output.addToTotals(temp.getCost(), temp.getDiscount());
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
            try{
                output.writeLine(l.writeItem());
            }catch(NullPointerException npe){
            output.writeError(npe);
            }
        //attempting to add totaling functionality to Transaction
        //double discount;
        //discount = lineItems[l].getDiscount();
        //output.updateTotals(lineItems[l].getCost());
        }
        output.writeTotals();
    }
}
