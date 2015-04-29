/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import beans.MyProduct;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author SAWSAN
 */
public class ProductDAO {

    Connection currentCon;
    ResultSet rs;
    Statement stmt;
    ArrayList<MyProduct> products = new ArrayList();
   
    public ArrayList<MyProduct> retrieveCategoryProducts(String CategoryName) {
        MyProduct prod ;
        
         //String searchQuery="select * from product , product_category where product_category.categoryId = product.category AND product_category.categoryName=' " + CategoryName+ " ' ;" ;
        
        try {
             currentCon = new ConnectionManager().getConnection();
             java.sql.PreparedStatement preparedstmt = currentCon.prepareStatement("select * from product , product_category where product_category.categoryId = product.category AND product_category.categoryName=? ");
            preparedstmt.setString(1, CategoryName);
            //stmt = currentCon.createStatement();
            rs = preparedstmt.executeQuery();
            while (rs.next()) {
                prod = new MyProduct() ;
                prod.setProductID(rs.getString("productId"));
                prod.setProductName(rs.getString("productName"));
                prod.setProductPrice(rs.getDouble("price"));
                prod.setProductDescr(rs.getString("description"));
                prod.setProductQuantity(rs.getInt("quantity"));
                prod.setProductCategory(CategoryName);
                products.add(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return products;
    }
    public ArrayList<MyProduct> retrievePriceProducts(double priceSearch) {
        MyProduct prod ;
         //String searchQuery="select * from product , product_category where product_category.categoryId = product.category AND product_category.categoryName=' " + CategoryName+ " ' ;" ;        
        try {
             currentCon =new  ConnectionManager().getConnection();
             java.sql.PreparedStatement preparedstmt = currentCon.prepareStatement("select * from product  where  product.price < "+priceSearch);
            rs = preparedstmt.executeQuery();
            while (rs.next()) {
                prod = new MyProduct() ;
                prod.setProductID(rs.getString("productId"));
                prod.setProductName(rs.getString("productName"));
                prod.setProductPrice(rs.getDouble("price"));
                prod.setProductDescr(rs.getString("description"));
                prod.setProductQuantity(rs.getInt("quantity"));
                products.add(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return products;
    }
    

    
    public MyProduct getProduct (int id) {
        MyProduct prod = null;
         try {
             currentCon = new ConnectionManager().getConnection();
             java.sql.PreparedStatement preparedstmt = currentCon.prepareStatement("select * from product where product.productId=? ");
            preparedstmt.setInt(1, id);
            //stmt = currentCon.createStatement();
            rs = preparedstmt.executeQuery();
            while (rs.next()) {
                prod = new MyProduct() ;
                prod.setProductID(rs.getString("productId"));
                prod.setProductName(rs.getString("productName"));
                prod.setProductPrice(rs.getDouble("price"));
                prod.setProductDescr(rs.getString("description"));
                prod.setProductQuantity(rs.getInt("quantity"));
                prod.setProductCategory(rs.getString("category"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return prod;
        
    }
}
