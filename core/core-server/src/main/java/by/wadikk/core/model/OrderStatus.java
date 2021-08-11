package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_status_name")
    private OrderStatusName statusName;

    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String description;
}
