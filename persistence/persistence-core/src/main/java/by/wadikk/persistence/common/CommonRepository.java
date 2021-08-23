package by.wadikk.persistence.common;


import by.wadikk.persistence.dao.common.CommonRepositoryDao;
import by.wadikk.persistence.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends BaseEntity> extends CommonRepositoryDao<E> {
}
