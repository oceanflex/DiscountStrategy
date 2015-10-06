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
public interface OutputStrategy {
    public void updateTotals(double[] in);
    public void writeLine(String[] s);
    public void writeCustomer(String custId);
    public void writeTotals();
}
