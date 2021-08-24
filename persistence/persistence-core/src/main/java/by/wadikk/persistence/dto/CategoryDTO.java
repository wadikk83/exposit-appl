package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CategoryDTO {

    private Long id;
    private String name;
    private List<Product> products = new ArrayList();
    private CategoryDTO parent;
    private List<CategoryDTO> childList;
    private Long idParent;

}
