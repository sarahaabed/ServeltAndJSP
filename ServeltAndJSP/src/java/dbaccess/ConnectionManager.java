package dbaccess;

//import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ConnectionManager {

    static Connection con;
    static String url = "jdbc:mySQL://localhost:3306/servletschema";

    public  Connection getConnection() {

        try {
            
            Class.forName("com.mysql.jdbc.Driver");            
            //DriverManager.registerDriver(new Driver());
            con =  DriverManager.getConnection(url, "root", "root");
            System.out.println("connected");
        } /*catch(ClassNotFoundException e)
         {
         System.out.println(e);
         }*/ catch (Exception ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}
