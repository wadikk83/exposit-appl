package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.AttributeName;
import by.wadikk.persistence.entities.BaseEntity;
import by.wadikk.persistence.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAttributeDTO extends BaseEntity {

    private Long id;
    private AttributeName attributeName;
    private Product product;
    private String value;
}
