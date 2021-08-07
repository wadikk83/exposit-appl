package by.wadikk.core.model;

import lombok.Data;

import java.util.List;

@Data
public class Category {

    private Integer id;
    private List<Category> childrenList;
    private Category parent;
    private String name;
    private int depth;// глубина
}
