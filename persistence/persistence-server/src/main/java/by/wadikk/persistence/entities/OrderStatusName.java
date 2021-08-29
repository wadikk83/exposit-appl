package by.wadikk.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class OrderStatusName extends BaseEntity{
    private String orderStatusName;

    @OneToMany(mappedBy = "statusName", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<OrderStatus> orderStatusList = new ArrayList<>();
}
