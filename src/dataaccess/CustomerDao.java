package dataaccess;

import model.Customer;
import java.util.List;

public interface CustomerDao {

    Customer findById(int id);

    default int insert(Customer obj) {
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }

    default List<Customer> getAll() {
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }

    default int getCount() {
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }

    default List<Customer> getPage(int itemPerpage, int page) {
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }

    default List<Customer> findByName(String name) {
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }
}
