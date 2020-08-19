package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Client;

/**
 * @author Rodrigo Dias Soares
 */
public class ClientDAO {
    private Connection conn;
    private PreparedStatement pstm;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Client> list;

    
    public ClientDAO() {
        try {
            conn = new ConnectionFactory().createConnection();
        } catch (Exception e) {
            throw new RuntimeException("Error connection 1: " + e);
        }
    }

    public void insert(Client client) {
        String sql = "insert into client(name, cpf, email, telephone, cellphone,"
                   + " gender, dateofbirth) values (?,?,?,?,?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, client.getName());
            pstm.setString(2, client.getEmail());
            pstm.setInt(3, client.getCpf());
            pstm.setInt(4, client.getTelephone());
            pstm.setInt(5, client.getCellPhone());
            pstm.setString(6, client.getGender());
            pstm.setDate(7, client.getDateOfBirth());
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

    public void updade(Client client) {

        String sql = "update client set name = ?, cpf = ?, email = ?,"
                + " telephone = ?, cellphone = ?, gender = ?, dateofbirth = ?"
                + " where id = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, client.getName());
            pstm.setString(2, client.getEmail());
            pstm.setInt(3, client.getCpf());
            pstm.setInt(4, client.getTelephone());
            pstm.setInt(5, client.getCellPhone());
            pstm.setString(6, client.getGender());
            pstm.setDate(7, client.getDateOfBirth());
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

        String sql = "delete from client where id = ?";

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

    public ArrayList<Client> select(String value) {
        String sql = "select * from client where description like '%" + value + "%'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Client e = new Client();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setCpf(rs.getInt("cpf"));
                e.setTelephone(rs.getInt("telephone"));
                e.setCellPhone(rs.getInt("cellphone"));
                e.setGender(rs.getString("gender"));
                e.setDateOfBirth(rs.getDate("dateofbirth"));
                list.add(e);

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

    public ArrayList<Client> selectAll(String value) {
        String sql = "select * from pet";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Client e = new Client();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setCpf(rs.getInt("cpf"));
                e.setTelephone(rs.getInt("telephone"));
                e.setCellPhone(rs.getInt("cellphone"));
                e.setGender(rs.getString("gender"));
                e.setDateOfBirth(rs.getDate("dateofbirth"));
                list.add(e);
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
