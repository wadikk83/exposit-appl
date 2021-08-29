package by.wadikk.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AttributeName extends BaseEntity {

    @Column(unique = true)
    private @NotNull String name;

    @OneToMany(mappedBy = "attributeName", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<ProductAttribute> productAttributeList = new ArrayList<>();
}
