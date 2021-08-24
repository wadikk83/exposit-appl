package by.wadikk.core.common;


import by.wadikk.core.repositoryDTO.common.CommonRepositoryDAO;
import by.wadikk.persistence.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends BaseEntity> extends CommonRepositoryDAO<E> {
}
