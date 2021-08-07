package by.wadikk.core.model;


import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Integer id;
    private @NonNull User user;
    private @NonNull Store store;
    private Date dateCreated;
    private List<OrderStatus> orderStatusList;
    private List<OrderItem> items = new ArrayList<>();
}
