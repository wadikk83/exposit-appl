package by.wadikk.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto extends AbstractDto {

    @NotNull(message = "The field cannot be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    private List<CategoryDto> categories;
    private List<ProductAttributeDto> productAttribute;

    private List<Long> articleId;
//    private List<ArticleDto> articleList;
}
