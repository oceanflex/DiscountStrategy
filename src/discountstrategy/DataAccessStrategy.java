/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.io.FileNotFoundException;

/**
 *
 * @author zsummers
 */
public interface DataAccessStrategy {

    /**
     * Tries to find a Customer by customer id.
     * @param custId - must not be null or empty
     * @return found Customer or null if not found or bad argument
     */
    Customer findCustomer(final String custId);

    /**
     * Tries to find a Proudct by product id.
     * @param prodId - must not be null or empty
     * @return found Product or null if not found or bad argument
     * @throws java.io.FileNotFoundException if there is no product by that ID
     */
    Product findProduct(final String prodId)throws FileNotFoundException;
    
}
