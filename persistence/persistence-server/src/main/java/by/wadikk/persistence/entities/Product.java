package by.wadikk.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity class Product
 *
 * @author Wadikk
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")

public class Product extends BaseEntity {

    @Column(unique = true)
    private @NonNull String name;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "cat_id"))
    private List<Category> categories = new ArrayList();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<ProductAttribute> productAttributes = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Article> articleList = new ArrayList<>();
}











