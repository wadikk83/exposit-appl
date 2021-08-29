package by.wadikk.persistence.entities;

import lombok.*;

import javax.persistence.*;

/**
 * Entity class Article
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Article extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private double price;
    private int amount;
}
