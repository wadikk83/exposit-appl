package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {

    private Long id;
    private Product product;
    private int amount;
    private double productPrice;
    private Store store;

    public double getItemPrice() {
        return productPrice * amount;
    }
}
