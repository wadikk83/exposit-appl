package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderStatusNameDTO {
    private Long id;
    private String orderStatusName;
    private List<OrderStatus> orderStatusList ;
}
