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
public class Startup {
    
    public static void main(String[] args) {
        String custId = "100";
        String[] prodIds = {"A101","C222","B225","B205"};
        DataAccessStrategy db = new FakeDatabase();
        OutputStrategy receipt = new Receipt(db);
        Register register = new Register(db);
        register.newTransaction(custId, receipt);
        register.addItem(prodIds[0], 2);
        register.addItem(prodIds[1], 1);
        register.endTransaction();
        receipt = new Receipt(db);
        custId = "200";
        register.newTransaction(custId, receipt);
        register.addItem(prodIds[2], 1);
        register.addItem(prodIds[3], 3);
        register.addItem(prodIds[0], 2);
        register.endTransaction();
        //String 
        
    }
    
}
