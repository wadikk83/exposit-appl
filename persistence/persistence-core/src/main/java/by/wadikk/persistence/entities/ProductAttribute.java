package by.wadikk.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Entity class Product attributes
 *
 * @author Wadikk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ProductAttribute extends BaseEntity{

    @ManyToOne()
    @JoinColumn(name = "attribute_name_id")
    private @NonNull AttributeName attributeName;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    private String value;
}
