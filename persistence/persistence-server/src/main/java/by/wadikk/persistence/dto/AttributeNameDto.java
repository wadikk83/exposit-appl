package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.BaseEntity;
import by.wadikk.persistence.entities.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttributeNameDto extends AbstractDto {

    private String name;
    private List<ProductAttributeDto> productAttributeList;
}
