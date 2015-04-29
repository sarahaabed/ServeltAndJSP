package DataBase;

import beans.MyUser;
import java.sql.*;

public class UserDAO {

    static Connection currentCon;
    static ResultSet rs;
    static Statement stmt;
    static PreparedStatement prpStmt = null;

    public static MyUser login(MyUser bean) {

        String dbName = "servletschema";
        String userEmail = bean.getUserEmail();
        String userPassword = bean.getUserPassword();
        String searchQuery
               // = "SELECT * FROM customer WHERE email='" + userEmail+ "' AND password='"+ userPassword+ "'";
        = "SELECT * FROM customer WHERE email='" + userEmail+ "' AND password='"+ userPassword+ "'" +"AND status="+1;

        //added to test 
        //  String searchZeft="SELECT * FROM customer";
        System.out.println("Your email xxxxxxxxxxxxxxxx is " + userEmail);
        System.out.println("Your password is " + userPassword);
        System.out.println("Query: " + searchQuery);
        System.out.println("email retreived from bean : " + userEmail);

        try {
            //connect to DB 
            currentCon = new ConnectionManager().getConnection();
            //men hena el 2araf da :( 
            
            prpStmt = currentCon.prepareStatement(searchQuery);
            rs = prpStmt.executeQuery(searchQuery);
            
            //boolean more = rs.next();
            // if user does not exist set the isValid variable to false
           // rs.first();
//            System.out.println("result stmnt xxxxxxx : " + rs.getString(3));
//            System.out.println("result stmnt xxxxxxx : " + rs.getString(2));
           // System.out.println("nnnnnnnnnnnnext" + rs.next());

            //System.out.println("result next : "+rs.next());
            //if user exists 
            //rs.first();

            if (rs.next()) {
                String name = rs.getString("name");
                String job = rs.getString("job");
                String address = rs.getString("address");
                String birthDay = rs.getString("birthDay");
                String creiditLimit = rs.getString("creditLimit");
                System.out.println("name from result set : " + name);
                System.out.println("job is : " + job);
                System.out.println("Welcome " + name);
                bean.setUserName(name);
                bean.setUserPassword(job);
                bean.setUserAddress(address);
                bean.setUserBirthDate(birthDay);
                bean.setUserCredit(creiditLimit);
                bean.setValid(true);
                bean.setStatus(1);
                
               //adding cookies 
                
            }
            else {
                System.out.println("After lasr row !!!!!");
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                bean.setValid(false);
                bean.setStatus(0);
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } finally {
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
