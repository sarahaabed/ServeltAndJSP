package dbaccess;


import beans.MyUser;
import dbaccess.ConnectionManager;
//import MyBeans.MyUser;
import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static MyUser login(MyUser bean) {

        Statement stmt = null;

        String userEmail = bean.getUserEmail();
        String userPassword = bean.getUserPassword();

        String searchQuery
                = "select * from customer where username='"
                + userEmail
                + "' AND password='"
                + userPassword
                + "'";

        System.out.println("Your user name is " + userEmail);
        System.out.println("Your password is " + userPassword);
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB 
            currentCon = new ConnectionManager().getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                bean.setValid(false);
            } //if user exists 
            else if (more) {
                String name = rs.getString("name");
                String job = rs.getString("job");
                String address = rs.getString("address");
                String birthDay = rs.getString("birthDay");
                String creiditLimit = rs.getString("creiditLimit");

                System.out.println("Welcome " + name);
                bean.setUserName(name);
                bean.setUserPassword(job);
                bean.setUserAddress(address);
                bean.setUserBirthDate(birthDay);
                bean.setUserCredit(creiditLimit);
           
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } 
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;

    }
}
