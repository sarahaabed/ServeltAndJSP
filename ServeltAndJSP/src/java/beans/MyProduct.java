/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Radwa Hassan Salah
 */
public class MyProduct {

    private String productID;

    private String productName;

    private double productPrice;

    private String productDescr;

    private String productCategory;
    
    private int productQuantity;

    ////////////////Setter and Getter of productCategory//////////////////
    /**
     * Get the value of productCategory
     *
     * @return the value of productCategory
     */
    public String getProductCategory() {
        return productCategory;
    }

    /**
     * Set the value of productCategory
     *
     * @param productCategory new value of productCategory
     */
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    ////////////////Setter and Getter of productDescr//////////////////
    /**
     * Get the value of productDescr
     *
     * @return the value of productDescr
     */
    public String getProductDescr() {
        return productDescr;
    }

    /**
     * Set the value of productDescr
     *
     * @param productDescr new value of productDescr
     */
    public void setProductDescr(String productDescr) {
        this.productDescr = productDescr;
    }

    ///////////////////Setter and Getter of productID////////////////
    /**
     * Get the value of productID
     *
     * @return the value of productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Set the value of productID
     *
     * @param productID new value of productID
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    //////////////////Setter and Getter of productName///////////////////
    /**
     * Get the value of productName
     *
     * @return the value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the value of productName
     *
     * @param productName new value of productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    ///////////////////Setter and Getter of productPrice/////////////////////////
    /**
     * Get the value of productPrice
     *
     * @return the value of productPrice
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Set the value of productPrice
     *
     * @param productPrice new value of productPrice
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return the quantity
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

}
