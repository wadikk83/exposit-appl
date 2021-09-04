package by.wadikk.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Category extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList();

    //ссылка на родителя
    @ManyToOne
    private Category parent;

    //список дочерних категорий
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Category> childList;

//    private @NotNull Long idParent;

}
