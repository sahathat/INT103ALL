/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess.imp;

import java.sql.Statement;
import dataaccess.OrderDao;
import java.util.Iterator;
import model.Order;
import model.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;

/**
 *
 * @author praisan
 */
public class OrderDaoImp implements OrderDao {

    @Override
      public int insert(Order order) {
        String sqlOrder = "INSERT INTO orders (order_date,order_customer_id,order_status)VALUES(?,?,?)";
        String sqlOrderItem = "INSERT INTO order_items (order_item_order_id,order_item_product_id,order_item_quantity,order_item_subtotal,order_item_product_price) VALUES(?,?,?,?,?)";
        int[] rows = null;
        try (
                 Connection conn = DatabaseConnection.getConnection();  
                PreparedStatement stmOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);  
                PreparedStatement stmOrderItem = conn.prepareStatement(sqlOrderItem, Statement.RETURN_GENERATED_KEYS)) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String mysql_datetime = sdf.format(order.getOrder_date());

            stmOrder.setString(1, mysql_datetime);
            stmOrder.setInt(2, order.getCustomer().getCustomer_id());
            stmOrder.setString(3, order.getOrder_status().name());
            conn.setAutoCommit(true);
            stmOrder.executeUpdate();
            
            ResultSet rs= stmOrder.getGeneratedKeys();
            int orderId =0;

            if(rs.next()){
                orderId = rs.getInt(1);
            }
            order.setOrder_id(orderId);

            conn.setAutoCommit(false);
            
            Iterator<OrderItem> items=order.getItems();
            while(items.hasNext()) {
                OrderItem item=items.next();
                stmOrderItem.setInt(1, orderId);
                stmOrderItem.setInt(2, item.getProd().getProduct_id());
                stmOrderItem.setInt(3, item.getQuantity());
                stmOrderItem.setDouble(4, item.getQuantity() * item.getProd().getProduct_price());
                stmOrderItem.setDouble(5, item.getProd().getProduct_price());
                stmOrderItem.addBatch();
            }
            rows = stmOrderItem.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException ex) {
                ex.printStackTrace();
        }
        int rowCount = 0;
        if (rows != null) {
            for (int i : rows) {
                rowCount += i;
            }
        }
        return rowCount;

    }
    
}
