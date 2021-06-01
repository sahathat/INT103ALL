package dataaccess.imp;

import dataaccess.CustomerDao;
import model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDaoImp implements CustomerDao {

    private static int count;

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try ( Connection conn = DatabaseConnection.getConnection();  Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                customers.add(customerORM(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return customers;
    }
    // method ไหนที่ไม่ได้เขียนก็ให้คง code นี้ไว้ได้: throw new UnsupportedOperationException("Not supported yet."); 

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stm = conn.prepareStatement("SELECT * FROM customers WHERE customer_fname LIKE ? OR customer_lname LIKE ? ")) {
            stm.setString(1, "%" + name + "%");
            stm.setString(2, "%" + name + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                customers.add(customerORM(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return customers;
    }

    private Customer customerORM(ResultSet rs) throws SQLException {
        return new Customer(
                rs.getInt("customer_id"),
                rs.getString("customer_fname"),
                rs.getString("customer_lname"),
                rs.getString("customer_email"),
                rs.getString("customer_password"),
                rs.getString("customer_street"),
                rs.getString("customer_city"),
                rs.getString("customer_state"),
                rs.getInt("customer_zipcode")
        );
    }

    @Override
    public int getCount() {
        try ( Connection conn = DatabaseConnection.getConnection();  Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM customers");
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public List<Customer> getPage(int itemPerpage, int page) {
        List<Customer> customers = new ArrayList<>();
        int first_row = (page - 1) * itemPerpage;
        String sql = "SELECT * FROM customers ORDER BY customer_id LIMIT ?,?";
        try ( Connection conn = DatabaseConnection.getConnection(); 
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, first_row);
            stm.setInt(2, itemPerpage);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                customers.add(customerORM(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return customers;
    }

    @Override
    public int insert(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findById(int id) {
        Customer customer=null;
        try ( Connection conn = DatabaseConnection.getConnection();  
                PreparedStatement stm = conn.prepareStatement("SELECT * FROM customers WHERE customer_id = ?")) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                customer=customerORM(rs);
            }
            return customer;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Customer();
    }

}
