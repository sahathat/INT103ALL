package dataaccess;

import model.Order;

public interface OrderDao {
    int insert(Order order);
    default Order findById(int id){
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }
}
