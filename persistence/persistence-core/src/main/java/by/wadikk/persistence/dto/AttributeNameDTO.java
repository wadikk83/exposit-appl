package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.ProductAttribute;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AttributeNameDTO {

    private Long id;
    private String name;
    private List<ProductAttribute> productAttributeList;
}
