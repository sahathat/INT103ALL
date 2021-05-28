
package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int order_id;
    private Date order_date;
    private Customer customer;
    private OrderStatus order_status;
    private ArrayList<OrderItem> item;
    
    public enum OrderStatus {
    CLOSE,PENDING_PAYMENT,COMPLETE,PROCESSING,PAYMENT_PREVIEW,PENDING,ON_HOLD,CANCELED,SUSPECTED_FRAUD ;
    }

    public Order(int order_id, Date order_date, Customer customer, OrderStatus order_status, ArrayList<OrderItem> item) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer = customer;
        this.order_status = order_status;
        this.item = item;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }

    public ArrayList<OrderItem> getItem() {
        return item;
    }

    public void setItem(ArrayList<OrderItem> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{order_id=").append(order_id);
        sb.append(", order_date=").append(order_date);
        sb.append(", customer=").append(customer);
        sb.append(", order_status=").append(order_status);
        sb.append(", item=").append(item);
        sb.append('}');
        return sb.toString();
    }
}
