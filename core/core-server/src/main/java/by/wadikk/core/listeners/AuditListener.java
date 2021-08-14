package by.wadikk.core.listeners;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PreRemove;

@Slf4j
public class AuditListener {

    @PreRemove
    private void beforeDelete(Object object) {
        log.info("The object {} has been deleted", object.toString());
    }
}
