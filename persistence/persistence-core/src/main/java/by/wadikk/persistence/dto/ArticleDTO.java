package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Product;
import by.wadikk.persistence.entities.Store;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDTO {

    private Long id;
    private Product product;
    private Store store;
    private double price;
    private int amount;
}
