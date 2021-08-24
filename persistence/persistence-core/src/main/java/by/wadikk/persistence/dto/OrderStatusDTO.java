package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Order;
import by.wadikk.persistence.entities.OrderStatusName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class OrderStatusDTO {

    private Long id;
    private OrderStatusName statusName;
    private Date timestamp;
    private Order order;
    private String description;
}
