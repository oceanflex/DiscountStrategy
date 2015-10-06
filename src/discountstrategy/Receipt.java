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
public class Receipt implements OutputStrategy{
    
    private String theOutput;
    private DataAccessStrategy db;
    private Customer customer;
    private double totalCost;
    private double totalDiscount;

    public Receipt(DataAccessStrategy db) {
        this.db = db;
        this.totalCost = 0.0;
        this.totalDiscount = 0.0;
    }

    @Override
    public void writeLine(String[] args) {
        
        
        for (String out : args){
            System.out.println(out);
        }
        
        
    }

    @Override
    public void writeCustomer(String custId) {
        System.out.println("Sold to: "+ db.findCustomer(custId));
    }

    @Override
    public void addToTotals(double cost, double discount) {
        this.totalCost += cost;
        this.totalDiscount += discount;
    }

    @Override
    public void writeTotals() {
        
    }
    
    
    
}
