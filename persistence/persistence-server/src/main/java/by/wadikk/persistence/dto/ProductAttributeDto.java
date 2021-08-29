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
public class ProductAttributeDto extends AbstractDto {

    private Long attributeNameId;
    private Long productId;
    private String value;
}
