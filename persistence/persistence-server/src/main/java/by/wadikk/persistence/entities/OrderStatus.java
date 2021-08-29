package by.wadikk.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class OrderStatus extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "order_status_name")
    private OrderStatusName statusName;

    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String description;
}
