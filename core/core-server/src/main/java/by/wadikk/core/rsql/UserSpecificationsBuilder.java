package by.wadikk.core.rsql;

import by.wadikk.core.util.SearchOperation;
import by.wadikk.core.util.SpecificationSearchCriteria;
import by.wadikk.persistence.entities.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public final class UserSpecificationsBuilder {

    private final List<SpecificationSearchCriteria> params;

    public UserSpecificationsBuilder() {
        params = new ArrayList<>();
    }

    // API

    public UserSpecificationsBuilder with(final String key, final SearchOperation operation, final Object value) {
        params.add(new SpecificationSearchCriteria(key, operation, value));
        return this;
    }

    public Specification<User> build() {
        if (params.size() == 0)
            return null;

        Specification<User> result = new UserSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new UserSpecification(params.get(i)))
                    : Specification.where(result).and(new UserSpecification(params.get(i)));
        }

        return result;
    }

    public final UserSpecificationsBuilder with(UserSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final UserSpecificationsBuilder with(SpecificationSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }

}
