package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Order;
import by.wadikk.persistence.entities.OrderStatusName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderStatusDTO {

    private Long id;
    private OrderStatusName statusName;
    private Date timestamp;
    private Order order;
    private String description;
}
