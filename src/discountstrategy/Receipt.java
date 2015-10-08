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
    private static double TAX_RATE = 0.055;
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
        StringBuilder print = new StringBuilder();
        double netCost = totalCost - totalDiscount;
        double taxDue = (totalCost - totalDiscount) * TAX_RATE;
        String evenStart = "\n\t\t\t\t";
        String breaker = "------\t------\t------";
        String totals =(evenStart+breaker+
                evenStart+"Cost:\t\t"+ money.format(totalCost)+
                evenStart+"Saved:\t\t"+money.format(totalDiscount)+
                evenStart+"Tax:\t\t" + money.format(taxDue)+
                evenStart+breaker+
                evenStart+"Total Due:\t"+ money.format(netCost+taxDue)+
                evenStart+breaker);
        System.out.println(totals);
    }
    
    
    
}
