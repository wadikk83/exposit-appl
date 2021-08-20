package by.wadikk.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class OrderStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_status_name")
    private OrderStatusNameEntity statusName;

    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    private String description;
}
