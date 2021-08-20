package by.wadikk.persistence.repository;


import by.wadikk.persistence.entities.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository <E extends BaseEntity> extends CrudRepository<E, Long> {
}
