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

public class ProductAttributeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "attribute_name_id")
    private @NonNull AttributeNameEntity attributeNameEntity;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    private String value;
}
