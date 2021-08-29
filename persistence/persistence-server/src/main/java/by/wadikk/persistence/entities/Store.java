package by.wadikk.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Store extends BaseEntity {

    private @NonNull String name;
    private String description;

    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Article> articleList;
}
