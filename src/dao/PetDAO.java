package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pet;

/**
 * @author Rodrigo Dias Soares
 */
public class PetDAO {
    
    private Connection conn;
    private PreparedStatement pstm;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Pet> list;

    public PetDAO() {
        try {
            conn = new ConnectionFactory().createConnection();
        } catch (Exception e) {
            throw new RuntimeException("Error connection 1: " + e);
        }
    }

    public void insert(Pet pet) {
        String sql = "insert into pet(name, breed, animal_tipe, owner) values (?,?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pet.getName());
            pstm.setString(2, pet.getBreed());
            pstm.setString(3, pet.getAnimalType());
            pstm.setInt(4, pet.getPetOwner());
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

    public void updade(Pet pet) {

        String sql = "update pet set name = ?, breed = ?, animal_tipe = ?, owner = ?"
                + " where id = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pet.getName());
            pstm.setString(2, pet.getBreed());
            pstm.setString(3, pet.getAnimalType());
            pstm.setInt(4, pet.getId());
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

    public ArrayList<Pet> select(String value) {
        String sql = "select * from pet where description like '%" + value + "%'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setBreed(rs.getString("breed"));
                p.setAnimalType(rs.getString("animal_tipe"));
                p.setPetOwner(rs.getInt("owner"));
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

    public ArrayList<Pet> selectAll(String value) {
        String sql = "select * from pet";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setBreed(rs.getString("breed"));
                p.setAnimalType(rs.getString("animal_tipe"));
                p.setPetOwner(rs.getInt("owner"));
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
