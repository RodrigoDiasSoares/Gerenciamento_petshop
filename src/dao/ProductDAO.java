package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Product;

/**
 *
 * @author Rodrigo Dias Soares
 */
public class ProductDAO {
    private Connection conn;
    private PreparedStatement pstm;
    private Statement stmt;
    private ResultSet rs;

    public ProductDAO() {
        try{
            conn = new ConnectionFactory().createConnection();
        }catch(Exception e){
            throw new RuntimeException("Error 2: " + e);
        }
    }
    
    public void insert(Product product){
        String sql = "insert into product(description, price, quantity) values (?,?,?)";
        
        try{
           pstm = conn.prepareStatement(sql);
           pstm.setString(1,product.getDescription());
           pstm.setDouble(2, product.getPrice());
           pstm.setInt(3, product.getQuantity());
           pstm.execute();
        }catch(Exception e){
            throw new RuntimeException("Error 3:" + e);
        }finally{
            try{
                if (pstm != null) pstm.close();
                
                if (conn != null) conn.close();
                    
            }catch(Exception e){
                throw new RuntimeException("Error 3 - close: " + e);
            }
        }
    }
    
    
    
}
