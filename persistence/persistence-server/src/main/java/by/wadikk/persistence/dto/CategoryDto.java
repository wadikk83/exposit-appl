package by.wadikk.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto extends AbstractDto {

    private String name;
    private List<ProductDto> products;
    private Long parentId;
    private List<CategoryDto> childList;
}
