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
public class Customer {
    private static final int STARTING_POINTS = 0;
    private String custID;
    private String name;
    private int rewardPoints;

    public Customer(String custID, String name) {
        this.custID = custID;
        this.name = name;
        this.rewardPoints = STARTING_POINTS;
    }

    public String getCustId() {
        return custID;
    }

    public String getName() {
        return name;
    }

    public int getRewardPoints(){
        return rewardPoints;
    }
    public void addPoints(int toAdd){
        rewardPoints += toAdd;
    }
    /**
     * 
     * @param toUse
     * @return return will be true, unless an exception occurs, calling class should catch
     */
    public boolean usePoints(int toUse){
        boolean pointsUsed;
        if(toUse>=this.rewardPoints){
            rewardPoints -= toUse;
            pointsUsed = true;
        }else{
            pointsUsed = false;
        }
        return pointsUsed;
    }
    
    @Override
    public String toString(){
        return this.name +" Customer ID: "+ this.custID;
    }
    
    
}
