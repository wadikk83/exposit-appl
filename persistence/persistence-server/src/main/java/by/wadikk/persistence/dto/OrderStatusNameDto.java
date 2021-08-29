package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.BaseEntity;
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
public class OrderStatusNameDto extends AbstractDto {

    private String orderStatusName;
    private List<OrderStatusDto> orderStatusList ;
}
