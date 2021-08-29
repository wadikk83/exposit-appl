package by.wadikk.core.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Filter implements Specification {

    Map<String, String> mapToFilter;



    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String, String> entry : mapToFilter.entrySet()) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue())));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }


}