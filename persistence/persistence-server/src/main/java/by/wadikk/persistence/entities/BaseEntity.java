package by.wadikk.persistence.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "ID")
    Long id;

    @Column(name = "created", updatable = false)
    LocalDateTime created;

    @Column(name = "updated", insertable = false)
    LocalDateTime updated;

    @PrePersist
    public void toCreate() {
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdate() {
        setUpdated(LocalDateTime.now());
    }

    public BaseEntity() {
        super();
    }
}
