package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderStatusNameDTO {
    private Long id;
    private String orderStatusName;
    private List<OrderStatus> orderStatusList ;
}
