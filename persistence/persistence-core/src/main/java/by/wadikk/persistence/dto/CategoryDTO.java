package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    private Long id;
    private String name;
    private List<Product> products = new ArrayList();
    private CategoryDTO parent;
    private List<CategoryDTO> childList;
    private Long idParent;

}
