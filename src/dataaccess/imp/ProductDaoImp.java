
package dataaccess.imp;

import dataaccess.ProductDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Department;
import model.Product;

public class ProductDaoImp implements ProductDao {

    @Override
    public int insert(Product obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findById(int id) {
        
        String sql = "SELECT * FROM products JOIN categories on products.product_category_id=categories.category_id JOIN departments ON categories.category_department_id=departments.department_id  WHERE products.product_id=?";
        Product product = null; 
        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                product = productORM(rs);
            }
        return product;
        
    }   catch (SQLException ex) {
            Logger.getLogger(ProductDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Product();
    }
    
//public Product(int product_id, Category category, String product_name, String product_description, double product_price, String product_image)
//public Category(int category_id, Department department, String category_name)
//public Department(int department_id, String department_name)
    
    private Product productORM(ResultSet rs) throws SQLException {

        return new Product(
                rs.getInt("product_id"),
                new Category(
                        rs.getInt("category_id"),
                        new Department(
                                rs.getInt("department_id"),
                                rs.getString("department_name")
                        ),
                        rs.getString("category_name")
                ),
                rs.getString("product_name"),
                rs.getString("product_description"),
                rs.getDouble("product_price"),
                rs.getString("product_image")
        );
    }
    
    private static void testProductDaoImp(){
        System.out.println(new ProductDaoImp().findById(1).toString());
    }
}
