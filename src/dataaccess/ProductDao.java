package dataaccess;

import java.util.List;
import model.Product;

public interface ProductDao {
    
    Product findById(int id);

    default int insert(Product obj) {
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }

    default List<Product> findByName(String name) {
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }

    default List<Product> getAll() {
        throw new UnsupportedOperationException("ยังไม่ได้ทำ");
    }

}
