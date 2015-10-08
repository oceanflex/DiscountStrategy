/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.NumberFormat;

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
    public void writeLine(String[] line) {
        
        StringBuilder out = new StringBuilder("");
        for (String temp : line){
            out.append(temp + "\t");
        }
        System.out.println(out);
        
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
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println("\t\t\t\t Cost:\t\t"+ money.format(totalCost)+
                "\n\t\t\t\t Discount:\t"+money.format(totalDiscount)+
                "\n\t\t\t\t Tax:\t\t" + money.format(totalCost * 0.056)+
                "\n\t\t\t\t Total Due:\t"+
                money.format((totalCost-totalDiscount)+(totalCost*0.056)));
    }
    
    
    
}
