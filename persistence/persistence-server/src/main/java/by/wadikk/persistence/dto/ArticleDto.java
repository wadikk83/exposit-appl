package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto extends AbstractDto {

    private Long productId;
    private Long storeId;
    private double price;
    private int amount;

}
