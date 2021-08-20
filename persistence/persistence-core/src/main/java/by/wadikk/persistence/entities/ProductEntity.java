package by.wadikk.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity class Product
 *
 * @author Wadikk
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private @NonNull String name;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @JoinTable(name = "product_category", joinColumns = { @JoinColumn(name = "person_id") }, inverseJoinColumns = {
//            @JoinColumn(name = "adress_id"), @JoinColumn(name = "country") })
//    private List<CategoryEntity> categories = new ArrayList();

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProductAttributeEntity> productAttributeEntities = new ArrayList<>();

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ArticleEntity> articleEntityList = new ArrayList<>();
}
