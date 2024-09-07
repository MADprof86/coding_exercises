package Classes;

import lombok.Data;
import java.util.List;
@Data
public class Order {
    private final List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }


}