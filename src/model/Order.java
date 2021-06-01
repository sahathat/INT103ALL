package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Order {

    private int order_id;
    private Date order_date;
    private Customer customer;
    private OrderStatus order_status;
    private ArrayList<OrderItem> items;
    private double totlePrice;

    public static enum OrderStatus {
        SUSPECTED_FRAUD, PROCESSING, PENDING_PAYMENT, PENDING,
        PAYMENT_REVIEW, ON_HOLD, COMPLETE, CLOSED, CANCELED;
    }

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(int order_id, Date order_date, Customer customer, OrderStatus order_status) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer = customer;
        this.order_status = order_status;
        this.items = new ArrayList<>();
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

    public Iterator<OrderItem> getItems() {
        return items.iterator();
    }

    public void addItem(OrderItem item) {
        if (item == null) {
            return;
        }

        this.totlePrice += item.getPrice() * item.getQuantity();
        this.items.add(item);
    }

    public void setItems(ArrayList<OrderItem> items) {
        if (items == null) {
            return;
        }
        this.items = items;
        updareTotalPrice(items);
    }

    private void updareTotalPrice(ArrayList<OrderItem> items) {
        this.totlePrice = 0;
        for (OrderItem item : items) {
            this.totlePrice += item.getPrice() * item.getQuantity();
        }
    }

    public double getTotlePrice() {
        return totlePrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{order_id=").append(order_id);
        sb.append(", order_date=").append(order_date);
        sb.append(", customer=").append(customer);
        sb.append(", order_status=").append(order_status);
        sb.append(", items=").append(items);
        sb.append(", totlePrice=").append(totlePrice);
        sb.append('}');
        return sb.toString();
    }
}
