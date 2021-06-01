
package bestsport;

import java.util.Iterator;
import model.Category;
import model.Customer;
import model.Department;
import model.Order;
import model.OrderItem;
import model.Product;

public class OrderTesting {
    public static void main(String[] args){
        orderTesting();
    }

    private static void orderTesting() {
        Order order = new Order();
        OrderItem item0=new OrderItem(
                1,
                new Product(
                        0,
                        new Category(
                                0,
                                new Department(0,"dep"),
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
        
        Iterator<OrderItem> items =order.getItem();
        while(items.hasNext()){
            System.out.println(items.next());
        }
        
        System.out.println(order.toString());
    }
    
    
}
