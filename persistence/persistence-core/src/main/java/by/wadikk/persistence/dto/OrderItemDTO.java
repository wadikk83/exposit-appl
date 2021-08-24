package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Article;
import by.wadikk.persistence.entities.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDTO {

    private Long id;
    private Article article;
    private Order order;
    private int amount;
    private double productPrice;

    public double getItemPrice() {
        return productPrice * amount;
    }
}
