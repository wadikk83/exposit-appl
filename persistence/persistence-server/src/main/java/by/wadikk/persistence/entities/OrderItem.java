package by.wadikk.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class OrderItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    private int amount;
    private double productPrice;

    public double getItemPrice() {
        return productPrice * amount;
    }
}
