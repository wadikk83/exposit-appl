package by.wadikk.core.listeners;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class DeleteEventListenerClass implements PostDeleteEventListener {

    @Override
    public boolean requiresPostCommitHanding(EntityPersister entityPersister) {
        // Does this listener require that after transaction hooks be registered?
        // Typically this is true for post-insert event listeners,
        // but may not be, for example,
        // in JPA cases where there are no callbacks defined for the particular entity.
        return true;
    }

    @Override
    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        //Subscriber to the delete events on your entities.
        log.info("Event was removed with data: {}", Arrays.toString(postDeleteEvent.getDeletedState()));
    }
}


