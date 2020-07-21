package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Rodrigo Dias Soares
 */
public class ConnectionFactory {
    private static final String userName = "test";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/crud?useSSL=false";
    
    public static Connection CreateConnection(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,userName,password);
            return conn;
            
        } catch (Exception e) {
            
            throw new RuntimeException("Error 1:" + e);
         
        }
    }
}
