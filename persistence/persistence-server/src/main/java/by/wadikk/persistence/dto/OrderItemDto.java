package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Article;
import by.wadikk.persistence.entities.BaseEntity;
import by.wadikk.persistence.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto extends AbstractDto {

    private Long articleId;
    private Long orderId;
    private int amount;
    private double productPrice;

    public double getItemPrice() {
        return productPrice * amount;
    }
}
