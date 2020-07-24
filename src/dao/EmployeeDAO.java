package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Employee;


/**
 * @author Rodrigo Dias Soares
 */
public class EmployeeDAO {
    private Connection conn;
    private PreparedStatement pstm;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Employee> list;

    public EmployeeDAO() {
        try {
            conn = new ConnectionFactory().createConnection();
        } catch (Exception e) {
            throw new RuntimeException("Error connection 1: " + e);
        }
    }
      
    public void insert(Employee employee) {
        String sql = "insert into employee(name, role, salary, cpf, telephone, cellphone, gender, dateofbirth) values (?,?,?,?,?,?,?,?)";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, employee.getName());
            pstm.setString(2, employee.getRole());
            pstm.setDouble(3, employee.getSalary());
            pstm.setInt(4, employee.getCpf());
            pstm.setInt(5, employee.getTelephone());
            pstm.setInt(6, employee.getCellPhone());
            pstm.setString(7, employee.getGender());
            pstm.setDate(8, employee.getDateOfBirth());
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

    public void updade(Employee employee) {

        String sql = "update employee set name = ?, role = ?, salary = ?, "
                + "cpf = ?, telephone = ?, cellphone = ?, gender = ?, dateofbirth = ?"
                + " where id = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, employee.getName());
            pstm.setString(2, employee.getRole());
            pstm.setDouble(3, employee.getSalary());
            pstm.setInt(4, employee.getCpf());
            pstm.setInt(5, employee.getTelephone());
            pstm.setInt(6, employee.getCellPhone());
            pstm.setString(7, employee.getGender());
            pstm.setDate(8, employee.getDateOfBirth());
            pstm.setInt(9, employee.getId());
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

        String sql = "delete from employee where id = ?";

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

    public ArrayList<Employee> select(String value) {
        String sql = "select * from employee where description like '%" + value + "%'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setRole(rs.getString("role"));
                e.setSalary(rs.getDouble("salary"));
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

    public ArrayList<Employee> selectAll(String value) {
        String sql = "select * from employee";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setRole(rs.getString("role"));
                e.setSalary(rs.getDouble("salary"));
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
