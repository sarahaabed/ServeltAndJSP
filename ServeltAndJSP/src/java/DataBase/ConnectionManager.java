package DataBase;

import static DataBase.UserDAO.rs;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {

    Connection con;
    String url;

    public Connection getConnection() {
        try {
            url = "jdbc:mysql://localhost:3306/servletschema";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "root");
            System.out.println("Connected");
        } catch (ClassNotFoundException e) {
            System.out.println("class mesh mawgood");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erooooooooooooooor");
        }

        return con;
    }
}
