package by.wadikk.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity articleEntity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;


    private int amount;
    private double productPrice;

    public double getItemPrice() {
        return productPrice * amount;
    }
}
