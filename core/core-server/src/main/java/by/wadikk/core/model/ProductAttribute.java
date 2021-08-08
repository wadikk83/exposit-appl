package by.wadikk.core.model;

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
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "attribute_name_id")
    private @NonNull AttributeName attributeName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private @NonNull Product product;
    private String value;
}
