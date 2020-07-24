package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Provider;

/**
 * @author Rodrigo Dias Soares
 */
public class ProviderDAO {

    private Connection conn;
    private PreparedStatement pstm;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Provider> list;

    public ProviderDAO() {
        try {
            conn = new ConnectionFactory().createConnection();
        } catch (Exception e) {
            throw new RuntimeException("Error connection 1: " + e);
        }
    }

    public void insert(Provider provider) {
        String sql = "insert into provider(name, email, telephone) values (?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, provider.getName());
            pstm.setString(2, provider.getEmail());
            pstm.setString(3, provider.getTelephone());
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

    public void updade(Provider provider) {

        String sql = "update provider set name = ?, email = ?, telephone = ?"
                + " where id = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, provider.getName());
            pstm.setString(2, provider.getEmail());
            pstm.setString(3, provider.getTelephone());
            pstm.setInt(4, provider.getId());
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

        String sql = "delete from provider where id = ?";

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

    public ArrayList<Provider> select(String value) {
        String sql = "select * from provider where description like '%" + value + "%'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Provider p = new Provider();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setTelephone(rs.getString("telephone"));
                list.add(p);

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

    public ArrayList<Provider> selectAll(String value) {
        String sql = "select * from provider";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Provider p = new Provider();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setTelephone(rs.getString("telephone"));
                list.add(p);
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
