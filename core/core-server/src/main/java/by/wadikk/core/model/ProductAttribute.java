package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Entity class Product attributes
 *
 * @author Wadikk
 */
@Data
@AllArgsConstructor
public class ProductAttribute {
    private Long id;
    private @NonNull AttributeName attribute;
    private @NonNull Product product;
    private String value;
}
