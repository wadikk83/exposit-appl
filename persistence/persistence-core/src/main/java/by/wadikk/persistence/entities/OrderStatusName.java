package by.wadikk.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity

public class OrderStatusName extends BaseEntity{
    private String orderStatusName;

    @OneToMany(mappedBy = "statusName", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderStatus> orderStatusList = new ArrayList<>();
}
