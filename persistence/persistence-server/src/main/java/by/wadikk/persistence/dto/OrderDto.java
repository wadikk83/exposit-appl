package by.wadikk.persistence.dto;


import by.wadikk.persistence.entities.BaseEntity;
import by.wadikk.persistence.entities.OrderItem;
import by.wadikk.persistence.entities.OrderStatus;
import by.wadikk.persistence.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto extends AbstractDto {

    private Long userId;
    private Date dateCreated;
    private List<OrderStatusDto> orderStatusList;
    private List<OrderItemDto> items ;
}
