package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Product;

/**
 * @author Rodrigo Dias Soares
 */
public class ProductDAO {
    private Connection conn;
    private PreparedStatement pstm;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Product> list = new ArrayList<Product>();

    public ProductDAO() {
        try{
            conn = new ConnectionFactory().createConnection();
        }catch(Exception e){
            throw new RuntimeException("Error connection 1: " + e);
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
            throw new RuntimeException("Error 2:" + e);
        }finally{
            try{
                if (pstm != null) pstm.close();
                
                if (conn != null) conn.close();
                    
            }catch(Exception e){
                throw new RuntimeException("Error close 1: " + e);
            }
        }
    }
    
    public void updade(Product product){
        
        String sql = "update product set description = ?, price = ?, quantity = ?"
                   + " where id = ?";
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, product.getDescription());
            pstm.setDouble(2, product.getPrice());
            pstm.setInt(3, product.getQuantity());
            pstm.setInt(4, product.getId());
            pstm.execute();
        } catch (Exception e) {
            
            throw new RuntimeException("Error 3:" + e);
            
        }finally{
            
            try {
                if (pstm != null) pstm.close();
                
                if (conn != null) conn.close();
                
            } catch (Exception e) {
                throw new RuntimeException("Error close 2: " + e);
            }
        }
    }
    
    public void delete(int id){
        
        String sql = "delete from product where id = ?";
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.execute(sql);
        } catch (Exception e) {
            
            throw new RuntimeException("Error close 4: " + e);
            
        }finally{
            
            try {
                if (pstm != null) pstm.close();
                
                if (conn != null) conn.close();
                
            } catch (Exception e) {
                throw new RuntimeException("Error close 3: " + e);
            }
        }
    }
    
    public ArrayList<Product> select(String value){
        String sql = "select * from product where description like '%"+value+"%'";
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                list.add(p);
                
            }
        } catch (Exception e) {
            throw new RuntimeException("Error 5: " + e);
        }finally{
            
            try {
                if (stmt != null) stmt.close();
                
                if (conn != null) conn.close();
                
                
            } catch (Exception e) {
                throw new RuntimeException("Error close 4: " + e);
            }
        }
        
        return list;
    }
    
     public ArrayList<Product> selectAll(String value){
        String sql = "select * from product";
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                list.add(p);
                
            }
        } catch (Exception e) {
            throw new RuntimeException("Error 5: " + e);
        }finally{
            
            try {
                if (stmt != null) stmt.close();
                
                if (conn != null) conn.close();
                
                
            } catch (Exception e) {
                throw new RuntimeException("Error close 5: " + e);
            }
        }
        
        return list;
    }
}
