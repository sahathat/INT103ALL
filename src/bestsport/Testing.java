/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestsport;

import dataaccess.imp.ProductDaoImp;
import java.util.Iterator;
import model.Category;
import model.Customer;
import model.Department;
import model.Order;
import model.OrderItem;
import model.Product;

/**
 *
 * @author praisan
 */
public class Testing {

    public static void main(String[] args) {
//        ordetTesting();
        testProductDaoImp();
    }

    private static void ordetTesting() {
        Order order = new Order();
        OrderItem item0 = new OrderItem(
                1,
                new Product(
                        0,
                        new Category(
                                0,
                                new Department(0, "dep"),
                                "name"
                        ),
                        "name",
                        "desc",
                        50,
                        "image"
                ),
                1,
                50
        );

        order.addItem(item0);
        order.setOrder_status(Order.OrderStatus.CLOSED);
        order.setCustomer(new Customer());

        Iterator<OrderItem> items = order.getItems();
        while (items.hasNext()) {
            System.out.println(items.next().toString());
        }

        System.out.println(order.toString());

    }

    private static void testProductDaoImp() {
        System.out.println(new ProductDaoImp().findById(1).toString());
    }

}
