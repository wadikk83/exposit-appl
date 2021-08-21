package by.wadikk.persistence.repository.common;


import by.wadikk.persistence.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository <E extends BaseEntity> extends JpaRepository<E, Long> {
}
