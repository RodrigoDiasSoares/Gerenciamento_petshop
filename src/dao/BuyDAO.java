package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Buy;

/**
 * @author rds_d
 */

public class BuyDAO {
   //serviceRendered, note, date, price, discount
    private Connection conn;
    private PreparedStatement pstm;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Buy> list;

    public BuyDAO() {
        try {
            conn = new ConnectionFactory().createConnection();
        } catch (Exception e) {
            throw new RuntimeException("Error connection 1: " + e);
        }
    }

    public void insert(Buy buy) {
        String sql = "insert into buy(client_id,serviceRendered, note, date, price, discount) values (?,?,?,?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, buy.getClient().getId());
            pstm.setString(2, buy.getServiceRendered());
            pstm.setString(3, buy.getNote());
            pstm.setDate(4, buy.getDate());
            pstm.setDouble(5, buy.getPrice());
            pstm.setInt(6, buy.getDiscount());
            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException("Error 2:" + e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                throw new RuntimeException("Error close 1: " + e);
            }
        }
    }

    public void updade(Buy buy) {

        String sql = "update buy set client_id = ?, serviceRendered = ?, note = ?"
                + ", date = ?, price = ?, discount = ?"
                + " where id = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, buy.getClient().getId());
            pstm.setString(2, buy.getServiceRendered());
            pstm.setString(3, buy.getNote());
            pstm.setDate(4, buy.getDate());
            pstm.setDouble(5, buy.getPrice());
            pstm.setInt(6, buy.getDiscount());
            pstm.setInt(7, buy.getId());
            pstm.execute();
        } catch (Exception e) {

            throw new RuntimeException("Error 3:" + e);

        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                throw new RuntimeException("Error close 2: " + e);
            }
        }
    }

    public void delete(int id) {

        String sql = "delete from pet where id = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute(sql);
        } catch (Exception e) {

            throw new RuntimeException("Error close 4: " + e);

        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                throw new RuntimeException("Error close 3: " + e);
            }
        }
    }

    public ArrayList<Buy> select(String value) {
        String sql = "select * from buy where description like '%" + value + "%'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Buy b = new Buy();
                b.setId(rs.getInt("id"));
                b.setClient(rs.getInt("client_id"));
                b.setServiceRendered(rs.getString("rendered"));
                b.setNote(rs.getString("note"));
                b.setDate(rs.getDate("date"));
                b.setPrice(rs.getDouble("price"));
                b.setDiscount(rs.getInt("discount"));
                list.add(b);

            }
        } catch (Exception e) {
            throw new RuntimeException("Error 5: " + e);
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                throw new RuntimeException("Error close 4: " + e);
            }
        }

        return list;
    }

    public ArrayList<Buy> selectAll(String value) {
        String sql = "select * from pet";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Buy b = new Buy();
                b.setId(rs.getInt("id"));
                b.setClient(rs.getInt("client_id"));
                b.setServiceRendered(rs.getString("rendered"));
                b.setNote(rs.getString("note"));
                b.setDate(rs.getDate("date"));
                b.setPrice(rs.getDouble("price"));
                b.setDiscount(rs.getInt("discount"));
                list.add(b);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error 5: " + e);
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                throw new RuntimeException("Error close 5: " + e);
            }
        }

        return list;
    }
}
