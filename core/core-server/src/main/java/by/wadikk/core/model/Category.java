package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@ElementCollection
    //private List<Category> childrenList;
    //@OneToOne
    //private Category parent;
    private String name;
    private int depth;// глубина
}
