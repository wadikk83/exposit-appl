package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class Article
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private Integer id;
    private Product product;
    private Store store;
    private double price;
    private int amount;
}
