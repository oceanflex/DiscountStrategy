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
public class Product {
    private String prodId;
    private String name;
    private double unitPrice;
    private DiscountStrategy discount;

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product(String prodId, String name, double unitPrice, DiscountStrategy discount) {
        this.prodId = prodId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }
    
    public double getDiscountAmt(double qty){
        return discount.getDiscountAmt(this.getUnitPrice(), qty);
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    //test main method
//    public static void main(String[] args) {
//        Product product = new Product("A100", "Baseball Hat", 20,
//                new QtyDiscount(.10, 5));
//        double amt = product.getDiscountAmt(2);
//        System.out.println("expected discount in amt of $0.00 real val = " + amt);
//    }
}
