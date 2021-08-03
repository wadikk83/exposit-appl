package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * Entity class Product
 *
 * @author Wadikk
 */

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private @NonNull String name;
    private List<Category> categories;
    private List<ProductAttribute> productAttributes;
}
