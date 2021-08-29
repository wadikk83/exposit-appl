package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.BaseEntity;
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
public class OrderStatusDto extends AbstractDto {

    private Long orderStatusNameId;
    private Date timestamp;
    private Long orderId;
    private String description;
}
