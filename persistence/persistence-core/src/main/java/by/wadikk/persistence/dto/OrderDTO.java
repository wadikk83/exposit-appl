package by.wadikk.persistence.dto;


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
public class OrderDTO {

    private Long id;
    private User user;
    private Date dateCreated;
    private List<OrderStatus> orderStatusList;
    private List<OrderItem> items = new ArrayList<>();
}
