package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Product;
import by.wadikk.persistence.entities.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {

    private Long id;
    private Product product;
    private Store store;
    private double price;
    private int amount;
}
