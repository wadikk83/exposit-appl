package by.wadikk.core.rsql;

import by.wadikk.core.util.SearchOperation;
import by.wadikk.core.util.SpecificationSearchCriteria;
import by.wadikk.persistence.entities.Product;
import by.wadikk.persistence.entities.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecificationsBuilder {

    private final List<SpecificationSearchCriteria> params;

    public ProductSpecificationsBuilder() {
        params = new ArrayList<>();
    }


    // API
    public ProductSpecificationsBuilder with(final String key, final SearchOperation operation, final Object value) {
        params.add(new SpecificationSearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Product> build() {
        if (params.size() == 0)
            return null;

        Specification<Product> result = new ProductSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new ProductSpecification(params.get(i)))
                    : Specification.where(result).and(new ProductSpecification(params.get(i)));
        }

        return result;
    }

    public final ProductSpecificationsBuilder with(UserSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final ProductSpecificationsBuilder with(SpecificationSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }

}
